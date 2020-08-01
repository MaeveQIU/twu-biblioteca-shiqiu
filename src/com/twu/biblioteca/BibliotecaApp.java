package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Message.WELCOME);
        System.out.println(Message.USER_LOGIN);

        String userCredential = scanner.nextLine();
        User user = getUserByString(userCredential);
        if (!UserDatabase.verifyUser(user)) {
            System.out.println(Message.LOGIN_FAILURE);
            System.exit(0);
        }

        while (true) {
            System.out.println(Message.MENU);
            int option = Integer.parseInt(scanner.nextLine());

            if (validateOption(option)) {
                startApplication(option, user);
            } else {
                System.out.println(Message.VALID_OPTION);
            }
        }
    }

    public static void startApplication(int option, User user) {
        for (Menu value : Menu.values()) {
            if (value.getOption() == option) {
                value.execute(option, user);
            }
        }
    }

    public static boolean validateOption(int option) {
        return Arrays.stream(Menu.values()).anyMatch(value -> value.getOption() == option);
    }

    public static User getUserByString(String credential) {
        String number = credential.split(",")[0];
        String password = credential.split(",")[1];
        return new User(number, password);
    }

}
