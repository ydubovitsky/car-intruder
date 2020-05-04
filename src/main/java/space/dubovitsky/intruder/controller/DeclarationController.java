package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import space.dubovitsky.intruder.model.Declaration;
import space.dubovitsky.intruder.model.Status;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.service.DeclarationService;

import java.util.List;

@Controller
public class DeclarationController {

    private final DeclarationService declarationService;

    @Autowired
    public DeclarationController(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    @GetMapping("/declaration")
    public String showDeclaration(Model model) {
        List<Declaration> declarationList = declarationService.getAllDeclarations();
        if (declarationList != null) {
            model.addAttribute("declarationList", declarationList);
        }
        return "declaration";
    }

    @PostMapping("/declaration")
    public String addDeclaration(
            @AuthenticationPrincipal User user, //! Получаем пользователя из Spring Security context
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String carNumber,
            @RequestParam String description,
            @RequestParam String status,
            Model model)
    {
        Declaration declaration = new Declaration(name, address, carNumber, description, Status.valueOf(status), user);

        declarationService.saveDeclaration(declaration);

        List<Declaration> declarationList = declarationService.getAllDeclarations();
        model.addAttribute("declarationList", declarationList);
        return "declaration";
    }

    @PostMapping("filter")
    public String filterDeclaration(@RequestParam(required = false, name = "filter") String filter, Model model) {
        List<Declaration> declarationList;

        if (filter != null) {
            declarationList = declarationService.declarationsByStatus(Status.valueOf(filter));
        } else {
            declarationList = declarationService.getAllDeclarations();
        }

        model.addAttribute("declarationList", declarationList);
        return "declaration";
    }
}
