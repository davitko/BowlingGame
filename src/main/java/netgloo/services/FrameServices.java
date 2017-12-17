package netgloo.services;

import netgloo.models.Frame;
import netgloo.repository.FrameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrameServices {

    @Autowired
    FrameRepository frameRepository;

    public String save(Frame newItem) {
        Frame object;
        try {
            object = newItem;
            frameRepository.save(object);
        }
        catch (Exception ex) {
            return "Error creating the new Frame: " + ex.toString();
        }
        return "User successfully created new Frame! (id = " + object.getId() + ")";
    }


}
