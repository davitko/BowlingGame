package netgloo.services;

import netgloo.models.Frame;
import netgloo.models.Player;
import netgloo.repository.PlayerRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class PlayerServices {

    private static final Logger LOG = Logger.getLogger(PlayerServices.class);
    private final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

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

    public Player create() {
        Player player = new Player();
        player.setOrdinalNumber(0);
        player.setName("");
        player.setScore(0);
        player.setDateOfPlaying(sdf.format(new Date()));
        player.setExtraFrame(new Frame());
        player.setFrames(new ArrayList<>());
        save(player);
        return player;
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
        try {
            Player tmpPlayer = playerRepository.findByDateOfPlaying(player.getDateOfPlaying());
            frameServices.save(frame);
            List<Frame> currentFrames = tmpPlayer.getFrames();
            if(currentFrames == null)
                currentFrames = new ArrayList<>();
            if(currentFrames.size() > 10)
                throw new IllegalArgumentException("Maximal number of frames is 10 plus Bonus Frame for a Strike of Spare in Last Frame");
            if(currentFrames.size() == 9 && frame.getFirstThrow().equals(10)) {
                LOG.info("STRIKE in last frame you have TWO more throws!");
//                currentFrames.add(frame);
            }
            if(currentFrames.size() == 9 && (frame.getFirstThrow() + frame.getSecondThrow() == 10)) {
                LOG.info("SPARE in last frame you have ONE more throws!");
//                currentFrames.add(frame);
            }
            if(currentFrames.size() == 10) {
                LOG.info("Bonus Frame");
//                currentFrames.add(frame);
            }
            if(currentFrames.size() < 9) {
                LOG.info("Normal Frame");
//                currentFrames.add(frame);
            }
            currentFrames.add(frame);
            tmpPlayer.setFrames(currentFrames);
            playerRepository.save(tmpPlayer);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void addExtraFrame(Player player, Frame frame) {
        try {
            Player tmpPlayer = playerRepository.findByDateOfPlaying(player.getDateOfPlaying());
            frameServices.save(frame);
            tmpPlayer.setExtraFrame(frame);
            playerRepository.save(tmpPlayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer calcScore(Player player) {
        Player tmpPlayer = playerRepository.findByDateOfPlaying(player.getDateOfPlaying());
        List<Frame> currentFrames = tmpPlayer.getFrames();
        Integer score = 0;
        try {
            for (Integer i = 0; i < currentFrames.size(); i++){
                // Check if some previous frame don't have calculated score (strike or spare)
//                for (Integer j = 0; j < i; j++) {
//                    // If score didn't calculated
//                    if(currentFrames.get(j).getFrameScore() == null) {
//                        // if it was strike
//                        if (currentFrames.get(j).getFirstThrow().equals(10)) {
//                            if (j+2 <= i) {
//                                if (currentFrames.get(j+1).getFrameScore() != null)
//                                    currentFrames.get(j).setFrameScore(currentFrames.get(j).getFirstThrow() + currentFrames.get(j+1).getFrameScore());
//                                if (currentFrames.get(j+2).getFrameScore() != null)
//                                    currentFrames.get(j).setFrameScore(currentFrames.get(j).getFirstThrow() + currentFrames.get(j+2).getFrameScore());
//                            }
//                        } else {
//                            Integer tmpScore = currentFrames.get(j).getFirstThrow() + currentFrames.get(j).getSecondThrow();
//                            // If it was spare
//                            if (tmpScore.equals(10)) {
//                                if (j + 1 <= i) {
//                                    if (currentFrames.get(j + 1).getFrameScore() != null)
//                                        currentFrames.get(j).setFrameScore(currentFrames.get(j).getFirstThrow() + currentFrames.get(j + 1).getFrameScore());
//                                }
//                            }
//                        }
//                    }
//                }

                Integer frameScore = currentFrames.get(i).getFirstThrow();
                // *** Strike ***
                if (currentFrames.get(i).getFirstThrow().equals(10)) {
                    LOG.info("Frame: " + i + " STRIKE!");
                    // Last Frame
                    try {
                        if (i == 9) {
    //                        score += currentFrames.get(i).getFirstThrow();
    //                        score += currentFrames.get(i).getSecondThrow();

                            frameScore += player.getExtraFrame().getFirstThrow();
                            frameScore += player.getExtraFrame().getSecondThrow();

                            Frame extraFrame = player.getExtraFrame();
                            extraFrame.setFrameScore(frameScore);
                            extraFrame.setCurrentPlayerScore(score += frameScore);
                            LOG.info("Extra Frame result is " + frameScore + " pins down!");
                            LOG.info("Extra Frame total score is " + score);
                            player.setExtraFrame(extraFrame);
                            player.setScore(score);
                            save(player);
                            continue;
                        }
                        // Before Last Frame
                        if (i == 8) {
    //                        score += currentFrames.get(i).getFirstThrow();
    //                        score += currentFrames.get(i).getSecondThrow();

                            frameScore += currentFrames.get(i+1).getFirstThrow();
                            frameScore += currentFrames.get(i+1).getSecondThrow();

                            frameScore += player.getExtraFrame().getFirstThrow();
                            frameScore += player.getExtraFrame().getSecondThrow();

                            Frame extraFrame = player.getExtraFrame();
                            extraFrame.setFrameScore(frameScore);
                            extraFrame.setCurrentPlayerScore(score += frameScore);
                            LOG.info("Extra Frame result is " + frameScore + " pins down!");
                            LOG.info("Extra Frame total score is " + score);
                            player.setExtraFrame(extraFrame);
                            player.setScore(score);
                            save(player);

                        }
                        // Not Last Frame
                        if(i+2 < currentFrames.size()) {
    //                        score += currentFrames.get(i).getFirstThrow();
    //                        score += currentFrames.get(i).getSecondThrow();

                            frameScore += currentFrames.get(i+1).getFirstThrow();
                            frameScore += currentFrames.get(i+1).getSecondThrow();

                            frameScore += currentFrames.get(i+2).getFirstThrow();
                            frameScore += currentFrames.get(i+2).getSecondThrow();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    else
//                        continue;
                }
//                else
//                    score += frames.get(i).getFirstThrow();

                // After 1st throw is not null
                if(!frameScore.equals(10)) {
                    frameScore = currentFrames.get(i).getFirstThrow() + currentFrames.get(i).getSecondThrow();
                    // *** Spare ***
                    if (frameScore.equals(10)) {
                        LOG.info("Frame: " + i + " SPARE!");
                        // Last Frame
                        try {
                            if (i == 9) {
    //                        score += currentFrames.get(i).getFirstThrow();
    //                        score += currentFrames.get(i).getSecondThrow();

                                frameScore += player.getExtraFrame().getFirstThrow();

                                Frame extraFrame = player.getExtraFrame();
                                extraFrame.setFrameScore(frameScore);
                                extraFrame.setCurrentPlayerScore(score += frameScore);
                                LOG.info("Extra Frame result is " + frameScore + " pins down!");
                                LOG.info("Extra Frame total score is " + score);
                                player.setExtraFrame(extraFrame);
                                player.setScore(score);
                                save(player);
                                continue;
                            }
                            // Not Last Frame
                            if (i + 1 < currentFrames.size()) {
    //                        score += currentFrames.get(i).getFirstThrow();
    //                        score += currentFrames.get(i).getSecondThrow();

                                frameScore += currentFrames.get(i + 1).getFirstThrow();
                                frameScore += currentFrames.get(i + 1).getSecondThrow();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        else
//                            continue;
                    }
                }

                // *** Regular ***
                score += frameScore;
                currentFrames.get(i).setFrameScore(frameScore);
                currentFrames.get(i).setCurrentPlayerScore(score);
//                frameServices.save(currentFrames.get(i));
                LOG.info("Frame: " + i + " result is " + frameScore + " pins down!");
                LOG.info("Frame: " + i + " total score is " + score);
                player.setFrames(currentFrames);
                player.setScore(score);
                save(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return score;
    }

}
