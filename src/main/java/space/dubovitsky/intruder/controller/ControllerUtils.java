package space.dubovitsky.intruder.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import space.dubovitsky.intruder.model.AbstractModelWithPhoto;
import space.dubovitsky.intruder.model.User;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

class ControllerUtils {

    static void setPhotoToEntity(
            @RequestParam MultipartFile photo,
            AbstractModelWithPhoto user,
            String photoPath) throws IOException
    {
        if (photo != null) {
            File photoDir = new File(photoPath);

            if (!photoDir.exists()) {
                photoDir.mkdir();
            }

            String prefixPhoto = UUID.randomUUID().toString();
            String avatarFinalName = prefixPhoto + "." + photo.getOriginalFilename();

            photo.transferTo(new File(photoPath + "/" + avatarFinalName));
            user.setPhoto(avatarFinalName);
        }
    }

}
