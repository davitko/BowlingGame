package netgloo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = {"/main"}, method = RequestMethod.GET)
public class MainController {

	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
    public String registration(Model model) {
//        model.addAttribute("userForm", new User());

        return "registration";
    }

}
