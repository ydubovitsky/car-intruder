package space.dubovitsky.intruder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/main")
    public String greetings(
            @RequestParam(name = "user", defaultValue = "Guest", required = false) String user,
            Model model)
    {   model.addAttribute("user", user);
        return "main";
    }

}
