package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import space.dubovitsky.intruder.model.Role;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.service.UserService;

import java.io.IOException;
import java.util.Collections;

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
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam("avatar") MultipartFile avatar) throws IOException
    {
        User user; //!TODO Приходится тут получать нового пользователя, поправить и сделать валидацию

        if (userService.getUserByName(username) == null) {
            user = new User();
        } else {
            return "redirect:/registration";
        }

        if (username != null && password != null && userService.getUserByName(username) == null) {

            ControllerUtils.setPhotoToEntity(avatar, user, avatarPath);

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
