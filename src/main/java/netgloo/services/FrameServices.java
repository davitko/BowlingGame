package netgloo.services;

import netgloo.models.Frame;
import netgloo.repository.FrameRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrameServices {

    private static final Logger LOG = Logger.getLogger(FrameServices.class);

    @Autowired
    FrameRepository frameRepository;

    public void save(Frame newItem) {
        Frame object = new Frame();
        try {
            object = newItem;
            frameRepository.save(object);
        }
        catch (Exception ex) {
            LOG.info("Error creating the new Frame: " + ex.toString());
        }
        LOG.info("User successfully created new Frame! (id = " + object.getId() + ")");
    }

    public Frame create() {
        Frame object = new Frame();
        object.setFirstThrow(0);
        object.setSecondThrow(0);
        object.setCurrentPlayerScore(0);
        object.setFrameScore(0);
        frameRepository.save(object);
        return object;
    }


}
