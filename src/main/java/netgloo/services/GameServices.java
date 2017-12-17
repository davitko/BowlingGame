package netgloo.services;

import netgloo.models.Frame;
import netgloo.models.Game;
import netgloo.models.Player;
import netgloo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

@Service
public class GameServices {

    private static final Logger LOG = Logger.getLogger(GameServices.class);

    private final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerServices playerServices;

    public String save(Game newItem) {
        Game object = new Game();
        try {
            object = newItem;
            gameRepository.save(object);
        }
        catch (Exception ex) {
            return "Error creating the new Game: " + ex.toString();
        }
        return "User successfully created new Game! (id = " + object.getId() + ")";
    }

    public void addPlayer(Game game, Player player) {
        Game tmpGame = gameRepository.findByDateOfGame(game.getDateOfGame());
        List<Player> currentPlayers = tmpGame.getPlayers();
        if(currentPlayers == null)
            currentPlayers = new ArrayList<>();
        if(currentPlayers.size() > 6)
            throw new IllegalArgumentException("Maximal number of players is 6");
        currentPlayers.add(player);
        tmpGame.setPlayers(currentPlayers);
        gameRepository.save(tmpGame);
    }

    public Game startSimulationOfGame() {
        Game game = new Game();
        game.setDateOfGame(sdf.format(new Date()));
        gameRepository.save(game);

        List<Player> players = new ArrayList<>();
        Player player1 = new Player();
        player1.setName("Milos");
        player1.setOrdinalNumber(1);
        player1.setDateOfPlaying(sdf.format(new Date()));
        players.add(player1);
        playerServices.save(player1);
        addPlayer(game, player1);
        Player player2 = new Player();
        player2.setName("Marko");
        player2.setOrdinalNumber(2);
        player2.setDateOfPlaying(sdf.format(new Date()));
        players.add(player2);
        playerServices.save(player2);
        addPlayer(game, player2);
        game.setPlayers(players);

        Boolean endGame = false;

        while (!endGame) {
            for (Player player: game.getPlayers()) {
                for (Integer f = 1; f < 11; f++){
                    Frame frame = new Frame();
                    Integer numOfPins = 10;
                    Integer frameScore = 0;
                    // 1st throw
                    frame.setFirstThrow(playerServices.throwBall(numOfPins));
                    frameScore = frame.getFirstThrow();
                    numOfPins -= frameScore;
                    // STRIKE
                    if (frameScore.equals(10)) {
                        LOG.info("Player " + player.getName() + " in frame number " + f + " STRIKE!");
                        playerServices.addFrame(player, frame);
                        if(f.equals(10)) {
                            Frame extraFrame = new Frame();
                            extraFrame.setFirstThrow(playerServices.throwBall(numOfPins));
                            LOG.info("Player " + player.getName() + " in first bonus throw ruins " + extraFrame.getFirstThrow() + " pins");
                            extraFrame.setSecondThrow(playerServices.throwBall(numOfPins));
                            LOG.info("Player " + player.getName() + " in second bonus throw ruins " + extraFrame.getSecondThrow() + " pins");
                            playerServices.addFrame(player, extraFrame);
                        }
                        continue;
                    }
                    // 2nd throw
                    frame.setSecondThrow(playerServices.throwBall(numOfPins));
                    frameScore = frame.getFirstThrow() + frame.getSecondThrow();
                    // SPARE
                    if (frameScore.equals(10)) {
                        LOG.info("Player " + player.getName() + " in frame number " + f + " SPARE!");
                        playerServices.addFrame(player, frame);
                        if(f.equals(10)) {
                            Frame extraFrame = new Frame();
                            extraFrame.setFirstThrow(playerServices.throwBall(numOfPins));
                            LOG.info("Player " + player.getName() + " in bonus throw ruins " + extraFrame.getFirstThrow() + " pins");
                            playerServices.addFrame(player, extraFrame);
                        }
                        continue;
                    }
                    // Normal throw
                    playerServices.addFrame(player, frame);
                    LOG.info("Player " + player.getName() + " in frame number " + f + " ruin " + frameScore + " pins");
                    continue;
                }
                LOG.info("Player " + player.getName() + " total score " + playerServices.calcScore(player));
            }
            endGame = true;
        }
        return gameRepository.findByDateOfGame(game.getDateOfGame());
    }


}
