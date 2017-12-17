package netgloo.controllers;

import netgloo.com.java.Integer.IntegerFn;
import netgloo.models.CarouselPack;
import netgloo.models.Frame;
import netgloo.models.Game;
import netgloo.models.Player;
import netgloo.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = {"/simulation"}, method = RequestMethod.GET)
public class SimulationController {

    @Autowired
    GameServices gameServices;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(Model model) {
        Game game = gameServices.startSimulationOfGame();
        List<Player> players = game.getPlayers();
        for (Integer i = 0; i < players.size(); i++) {
            List<Frame> frames = players.get(i).getFrames();
            model.addAttribute("frames"+i.toString(), frames);
        }

        model.addAttribute("players", players);

        return "simulation";
    }
}
