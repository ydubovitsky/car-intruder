package space.dubovitsky.intruder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import space.dubovitsky.intruder.model.Declaration;
import space.dubovitsky.intruder.model.Status;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.service.DeclarationService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
            @RequestParam("photo") MultipartFile photo,
            Model model) throws IOException {
        Declaration declaration = new Declaration(name, address, carNumber, description, Status.valueOf(status), user);

        if (photo != null) {
            File uploadPhotoDir = new File(photoPath);

            if (!uploadPhotoDir.exists()) {
                uploadPhotoDir.mkdir(); //* Если не существует директории для загрузки фотографий, создаем ее
            }

            String uuidFile = UUID.randomUUID().toString();
            String uniqPhotoName = uuidFile + "." + photo.getOriginalFilename(); //* генерируем новое имя файла

            photo.transferTo(new File(photoPath + "/" + uniqPhotoName));

            declaration.setPhoto(uniqPhotoName);
        }

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
