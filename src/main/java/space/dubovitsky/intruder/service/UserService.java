package space.dubovitsky.intruder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.dubovitsky.intruder.model.User;
import space.dubovitsky.intruder.repositories.UserRepo;

@Service
public class UserService {

    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserByName(String name) {
        User byName = userRepo.findByUsername(name);
        return byName;
    }

    public void saveUser(User user) {
        userRepo.save(user);
    }
}
