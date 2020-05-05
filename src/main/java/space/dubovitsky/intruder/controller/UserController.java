package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import space.dubovitsky.intruder.model.Role;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.repositories.UserRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize(value = "hasAnyAuthority('INSPECTOR')") //?
public class UserController {

    private UserRepo userRepo;

    @Autowired //! Можно и не писать
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @GetMapping
    public String userPage(Model model) {
        List<User> allUsers = userRepo.findAll();
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("rolesArray", Role.values()); //? Вынести в сервис
        return "users-list";
    }

    @PostMapping
    public String getAllUsers(Model model) {
        List<User> allUsers = userRepo.findAll();
        model.addAttribute("allUsers", allUsers);
        model.addAttribute("rolesArray", Role.values()); //? Вынести в сервис
        return "users-list";
    }

    @PostMapping("/edit")
    public String editUser(
            @RequestParam("id") User user,
            @RequestParam Map<String, String> form, //* Параметры ключ-значение из формы
            @RequestParam String username,
            @RequestParam String password,
            Model model)
    {
        user.setUsername(username);
        user.setPassword(password);

        Set<String> roles = Arrays.stream(Role.values()) //* Получаем множество всех ролей
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear(); //* Удаляем все роли у пользователя

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key)); //* Добавляем новую роль пользователю
            }
        }

        userRepo.save(user);

        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") User user) {
        userRepo.delete(user);

        return "redirect:/user";
    }
}

