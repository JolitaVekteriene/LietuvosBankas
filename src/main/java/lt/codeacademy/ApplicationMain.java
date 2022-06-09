package lt.codeacademy;

import lt.codeacademy.service.UserService;

public class ApplicationMain {
        public static void main(String[] args) {

            UserService userService = new UserService();
            userService.createUser();

        }
    }