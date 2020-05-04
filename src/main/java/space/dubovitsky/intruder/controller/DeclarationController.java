package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import space.dubovitsky.intruder.model.Declaration;
import space.dubovitsky.intruder.service.DeclarationService;

import java.util.List;

@Controller
public class DeclarationController {

    private DeclarationService declarationService;

    @Autowired
    public DeclarationController(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    @GetMapping("/declaration")
    public String showDeclaration(Model model) {
        List<Declaration> declarationList = declarationService.getDeclarationList();
        model.addAttribute("declarationList", declarationList);
        return "declaration";
    }

    @PostMapping("/declaration")
    public String addDeclaration(
            @RequestParam String name,
            @RequestParam String address,
            @RequestParam String carNumber,
            @RequestParam String description,
            Model model)
    {
        Declaration declaration = new Declaration(name, address, carNumber, description);

        declarationService.saveDeclaration(declaration);

        List<Declaration> declarationList = declarationService.getDeclarationList();
        model.addAttribute("declarationList", declarationList);
        return "declaration";
    }

}
