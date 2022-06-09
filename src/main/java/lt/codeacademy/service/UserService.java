package lt.codeacademy.service;

import lt.codeacademy.entity.User;
import lt.codeacademy.repository.UserRepository;

public class UserService {
    private static final UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public static void createUser(User user) {
        User user1 = new User(null, "Jolita", "Vekterine", "ginjolita@gmail.com");
        repository.createUser(user1);

    }
}


