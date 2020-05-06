package space.dubovitsky.intruder.utils;

import org.springframework.web.multipart.MultipartFile;
import space.dubovitsky.intruder.model.AbstractModelWithPhoto;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ServiceUtils {

    public static void setPhotoToEntity(
            MultipartFile photo,
            AbstractModelWithPhoto user,
            String photoPath) throws IOException
    {
        if (photo != null && photo.getOriginalFilename() != null) {
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

