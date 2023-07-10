package application;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Application {

    private final UserService userService;

    public Application(UserService userService) {
        this.userService = userService;
    }

    public void getUsersFromDb() {
        List<User> users = userService.getAllUsers();
        users.forEach(user -> System.out.println("application.User: " + user.getId()));
    }
}