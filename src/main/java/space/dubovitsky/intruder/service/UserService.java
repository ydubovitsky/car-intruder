package space.dubovitsky.intruder.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import space.dubovitsky.intruder.model.Role;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.repositories.UserRepo;
import space.dubovitsky.intruder.utils.MailSender;
import space.dubovitsky.intruder.utils.ServiceUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    private final MailSender mailSender;

    @Value("${activation.host}")
    private String activationHost;

    @Autowired
    public UserService(UserRepo userRepo, MailSender mailSender) {
        this.userRepo = userRepo;
        this.mailSender = mailSender;
    }

    public User getUserByName(String name) {
        return userRepo.findByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    @SneakyThrows
    public boolean addUser(String username, String password, String avatarPath, String email, MultipartFile avatar) {
        User user; //!TODO Приходится тут получать нового пользователя, поправить и сделать валидацию

        if (getUserByName(username) == null) { //* Если пользователя с таким именем нет в базе данных
            user = new User();
        } else {
            return false;
        }

        ServiceUtils.setPhotoToEntity(avatar, user, avatarPath);

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        String activationCode = UUID.randomUUID().toString();
        user.setActivationCode(activationCode); //* генерируем код активации

        userRepo.save(user);

        mailSender.sendMsg(email, "Activation Code", getActivationMsg(username, activationCode));

        return true;
    }

    private String getActivationMsg(String username, String activationCode) {
        return String.format(
                "Hello, %s! For activate your email, please visit %s/activate/%s",
                username,
                activationHost,
                activationCode
        );
    }

    public boolean activateUser(String code) {
        User byActivationCode = userRepo.findByActivationCode(code);

        if (byActivationCode == null) {
            return false;
        }

        byActivationCode.setActivationCode(null); //* Пользователь подтвердил свою почту
        userRepo.save(byActivationCode);

        return true;
    }
}

