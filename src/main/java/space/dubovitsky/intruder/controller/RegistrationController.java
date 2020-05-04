package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import space.dubovitsky.intruder.model.Role;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.service.UserService;

import java.util.Collections;

@Controller
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(
            User user,
            @RequestParam String username,
            @RequestParam String password)
    {
        if (username != null && password != null && userService.getUserByName(username) == null) {
            user.setUsername(username);
            user.setPassword(password);
            user.setActive(true);
            user.setRoles(Collections.singleton(Role.USER));
            userService.saveUser(user);
            return "redirect:/login";
        } else {
            return "registration";
        }
    }

}
