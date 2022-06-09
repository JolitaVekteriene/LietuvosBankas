package lt.codeacademy.controller;


import lt.codeacademy.entity.User;
import lt.codeacademy.service.UserService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceController {
    private final Scanner scanner;


    public UserInterfaceController() {
        scanner = new Scanner(System.in);
        UserService userService = new UserService();

    }

    public void startApplication() {
        String action;
        do {
            showMenu();
            action = scanner.nextLine();
            selectAction(action);
        } while (!action.equals("5"));
    }

    private void showMenu() {
        System.out.println("""
                1. RegistrationUser
                2. Sending money
                3. Exit
                """);
    }

    private void selectAction(String action) {
        switch (action) {
            case "1" -> registrationUser();
            case "2" -> System.out.println("sending money");
            case "3" -> System.out.println("System turning of");
            default -> System.out.println("action does not exist");
        }
    }

    private void registrationUser() {
        System.out.println("Insert name");
        String name = scanner.nextLine();
        System.out.println("Insert surname");
        String surname = scanner.nextLine();
        System.out.println("Insert phone");
        String phone = scanner.nextLine();
        System.out.println("Insert email");
        String email = scanner.nextLine();
        System.out.println("Insert salary");
        BigDecimal salary = new BigDecimal(scanner.nextLine());

        User user = new User(name, surname, email);
        UserService.createUser(user);

    }


    private User getUser(List<User> users) {
        User user;
        do {
            Long employerId = getCorrectNumber();
            user = users.stream().filter(e -> e.getId().equals(employerId)).findFirst().orElse(null);
            if (user == null) {
                System.out.println("User does not exist, please insert existing user id");
            }

        } while (user != null);

        return user;
    }

    private Long getCorrectNumber() {
        while (true) {
            try {
                return Long.valueOf(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Incorect number, please try again");

            }
        }
    }
}

