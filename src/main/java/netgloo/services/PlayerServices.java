package netgloo.services;

import netgloo.models.Frame;
import netgloo.models.Player;
import netgloo.repository.PlayerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PlayerServices {

    private static final Logger LOG = Logger.getLogger(PlayerServices.class);

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    FrameServices frameServices;

    public String save(Player newItem) {
        Player object;
        try {
            object = newItem;
            playerRepository.save(newItem);
        }
        catch (Exception ex) {
            return "Error creating the new Player: " + ex.toString();
        }
        return "User successfully created new Player! (id = " + object.getId() + ")";
    }

    public Integer throwBall(Integer numOfPinsLeft) {
        Integer throwScore = randomPinsDown(numOfPinsLeft);
        if (throwScore.equals(10)) {
            LOG.info("STRIKE!");
        }
        return throwScore;
    }

    public Integer randomPinsDown(Integer numOfPins) {
        Integer min = 0;
        Integer max = numOfPins;

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void addFrame(Player player, Frame frame) {
        Player tmpPlayer = playerRepository.findByDateOfPlaying(player.getDateOfPlaying());
        frameServices.save(frame);
        List<Frame> currentFrames = tmpPlayer.getFrames();
        if(currentFrames == null)
            currentFrames = new ArrayList<>();
        if(currentFrames.size() > 10)
            throw new IllegalArgumentException("Maximal number of frames is 10 plus Bonus Frame for a Strike of Spare in Last Frame");
        if(currentFrames.size() == 9 && frame.getFirstThrow().equals(10)) {
            LOG.info("STRIKE in last frame you have TWO more throws!");
            currentFrames.add(frame);
        }
        if(currentFrames.size() == 9 && (frame.getFirstThrow() + frame.getSecondThrow() == 10)) {
            LOG.info("SPARE in last frame you have ONE more throws!");
            currentFrames.add(frame);
        }
        if(currentFrames.size() == 10) {
            LOG.info("Bonus Frame");
            currentFrames.add(frame);
        }
        if(currentFrames.size() < 9) {
            LOG.info("Normal Frame");
            currentFrames.add(frame);
        }
        tmpPlayer.setFrames(currentFrames);
        playerRepository.save(tmpPlayer);
    }

    public Integer calcScore(Player player) {
        Player tmpPlayer = playerRepository.findByDateOfPlaying(player.getDateOfPlaying());
        List<Frame> currentFrames = tmpPlayer.getFrames();
        Integer score = 0;
        try {
            for (Integer i = 0; i < currentFrames.size(); i++){

                if (i == 10) {
                    score += currentFrames.get(i).getFirstThrow();
                    score += currentFrames.get(i).getSecondThrow();
                }

                // Strike
                if (currentFrames.get(i).getFirstThrow().equals(10)) {
                    LOG.info("Frame: " + i+1 + " STRIKE!");
                    if(i+2 <= currentFrames.size()) {
                        score += currentFrames.get(i).getFirstThrow();
                        score += currentFrames.get(i).getSecondThrow();

                        score += currentFrames.get(i+1).getFirstThrow();
                        score += currentFrames.get(i+1).getSecondThrow();

                        score += currentFrames.get(i+2).getFirstThrow();
                        score += currentFrames.get(i+2).getSecondThrow();
                    }else
                        return score;
                }
//                else
//                    score += frames.get(i).getFirstThrow();

                // Spare
                Integer frameScore = currentFrames.get(i).getFirstThrow() + currentFrames.get(i).getSecondThrow();
                if(frameScore.equals(10)) {
                    LOG.info("Frame: " + i+1 + " SPARE!");
                    if(i+1 <= currentFrames.size()) {
                        score += currentFrames.get(i).getFirstThrow();
                        score += currentFrames.get(i).getSecondThrow();

                        score += currentFrames.get(i+1).getFirstThrow();
                        score += currentFrames.get(i+1).getSecondThrow();
                    }else
                        return score;
                }
                // Regular
                score += frameScore;
                LOG.info("Frame: " + i+1 + " result is " + score + " pins down!");
                player.setScore(score);
                save(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return score;
    }
}
