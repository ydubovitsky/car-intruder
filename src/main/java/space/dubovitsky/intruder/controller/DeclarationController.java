package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import space.dubovitsky.intruder.model.Declaration;
import space.dubovitsky.intruder.model.Status;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.service.DeclarationService;
import space.dubovitsky.intruder.utils.ServiceUtils;

import java.io.IOException;
import java.util.List;

@Controller
public class DeclarationController {

    @Value("${upload.path}")
    private String photoPath;

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
            model.addAttribute("declarationStatuses", Status.values());
        }
        return "declaration";
    }

    @PostMapping("/declaration")
    public String addDeclaration(
            @AuthenticationPrincipal User user, //! Получаем пользователя из Spring Security context
            @ModelAttribute Declaration declaration,
            @RequestParam("photoAccident") MultipartFile photoAccident,
            Model model) throws IOException
    {
        declaration.setUser(user); //* Вручнуя сетаем пользователя из Security контекста
        ServiceUtils.setPhotoToEntity(photoAccident, declaration, photoPath);

        declarationService.saveDeclaration(declaration);

        List<Declaration> declarationList = declarationService.getAllDeclarations();
        model.addAttribute("declarationList", declarationList);
        return "redirect:/declaration";
    }

    @PostMapping("filter") //! TODO Поправить метод фильтрации
    public String filterDeclaration(@RequestParam(required = false, name = "filter") String filter, Model model) {
        List<Declaration> declarationList;

        if (filter != null) {
            declarationList = declarationService.declarationsByStatus(Status.valueOf(filter));
        } else {
            declarationList = declarationService.getAllDeclarations();
        }

        model.addAttribute("declarationList", declarationList);
        return "redirect:/declaration";
    }

    @PostMapping("/declaration/edit")
    public String editDeclaration(
            @RequestParam("id") Declaration declaration,
            @RequestParam("status") String status)
    {
        declaration.setStatus(Status.valueOf(status));
        declarationService.saveDeclaration(declaration);

        return "redirect:/declaration";
    }
}
