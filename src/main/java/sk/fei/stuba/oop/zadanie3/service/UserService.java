package  sk.fei.stuba.oop.zadanie3.service;


import org.springframework.stereotype.Service;
import sk.fei.stuba.oop.zadanie3.model.user.User;
import sk.fei.stuba.oop.zadanie3.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final User dummyUser;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        dummyUser = new User();
    }

    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }


    public User getUserById(String userId) {
        try {
            checkIfUserIdExists(userId);
            return userRepository.getUserById(userId);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
        return dummyUser;
    }

    public void addNewUser(User user) {
        try {
            checkIfUserIsValid(user);
            user.setUserId(UUID.randomUUID().toString());
            userRepository.addUser(user);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void editUser(User user) {
        checkIfUserIsValid(user);
        userRepository.editUser(user);
    }

    private void checkIfUserIdExists(String userId) {
        if (!userRepository.checkIfUserIdExists(userId)) {
            throw new IllegalArgumentException("User not in database");
        }
    }

    private void checkIfUserIsValid(User user) {
        if (user == null  || user.getFirstName() == null ||
                user.getLastName() == null || user.getBirthId() <= 0 ||
                user.getEmail() == null) {
            throw new IllegalArgumentException("Not valid user, cant be added.");
        }
    }

}
