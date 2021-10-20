package com.paw2go.usermodification;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private static Map<Integer, User> userRepo = new HashMap<>();
    static {
        User user1 = new User();
        user1.setIdUser(1);
        user1.setFullName("Marco Gonzalez");
        user1.setEmail("marco.gonzalez@correo.com");
        user1.setPassword("2345");
        user1.setUserName("MarcGon2");

        userRepo.put(user1.getIdUser(), user1);

        User user2 = new User();
        user2.setIdUser(2);
        user2.setFullName("Karina Sanchez");
        user2.setEmail("karina.sanchez@correo.com");
        user2.setPassword("3456");
        user2.setUserName("KarSan3");

        userRepo.put(user2.getIdUser(), user2);

    }
    @Override
    public void createUser(User user) {
        userRepo.put(user.getIdUser(), user);
    }
    @Override
    public void updateUser(int id, User user) {
        userRepo.remove(id);
        user.setIdUser(id);
        userRepo.put(id, user);
    }
    @Override
    public void updateUser(int id) {
        userRepo.remove(id);

    }
    @Override
    public Collection<User> getUsers() {
        return userRepo.values();
    }
}