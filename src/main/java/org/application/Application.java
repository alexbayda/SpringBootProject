package org.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Application {

    private final UserService userService;

    private final UserRepository userRepository;

    @Autowired
    public Application(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public void getUsersFromDb() {
        List<User> users = userService.getAllUsers();
        users.forEach(user -> System.out.println("org.application.User: " + user.getId()));
    }

    public void getUsersFromDbFromModel(){
        List<User> users = userRepository.findAll();
            users.forEach(user -> System.out.println("User: " + user.getId() + ", Name: " + user.getPartialName()));
    }
}