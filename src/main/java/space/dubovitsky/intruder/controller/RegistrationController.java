package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import space.dubovitsky.intruder.service.UserService;

import java.io.IOException;

@Controller
public class RegistrationController {

    @Value("${upload.avatar}")
    private String avatarPath;

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
            @RequestParam String username, //? Мб получать форму и искать в ней ключи?
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam("avatar") MultipartFile avatar,
            Model model) throws IOException
    {
        boolean addedResult = userService.addUser(username, password, avatarPath, email, avatar);

        if (addedResult) { //* Если пользователь успешно добавлен
            return "redirect:/login";
        } else {
            model.addAttribute("registerMsg", "User already exists");
            return "registration";
        }
    }

    @GetMapping("/activate/{code}")
    public String activateUser(@PathVariable String code, Model model) {
        boolean isActivate = userService.activateUser(code);

        if (isActivate) {
            model.addAttribute("message", "User is active");
        } else {
            model.addAttribute("message", "Activation code is not found");
        }

        return "login";
    }

}
