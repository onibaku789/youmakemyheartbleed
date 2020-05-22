package sk.fei.stuba.oop.zadanie3.repository;


import org.springframework.stereotype.Service;
import sk.fei.stuba.oop.zadanie3.model.user.User;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserRepository {

    private Map<UUID,User> allUser;
    private User dummy;


    public UserRepository() {
        allUser = new HashMap<>();
    }

    public User getUserById(UUID userId) {
        return new User(allUser.get(userId));
    }

    public void addUser(User user) {
       allUser.put(user.getUserId(),user);
    }

    public List<User> getAllUser() {
        return new ArrayList<>(allUser.values());
    }

    public boolean checkIfUserIdExists(UUID userId) {
        return allUser.containsKey(userId);
    }

    public void editUser(User user) {
       allUser.replace(user.getUserId(),user);
    }

}

