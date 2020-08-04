package com.twu.biblioteca;

import com.twu.biblioteca.resource.DataProvider;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.Authenticator;
import com.twu.biblioteca.resource.Menu;
import com.twu.biblioteca.resource.Message;

import java.util.Scanner;

public class BibliotecaApp {

    private static Scanner scanner = new Scanner(System.in);
    private static DataProvider dataProvider = new DataProvider();

    public static void main(String[] args) {
        User user = login();
        run(user);
    }

    public static User login() {
        System.out.println(Message.WELCOME + "\n" + Message.USER_LOGIN);
        String userInput = scanner.nextLine();
        return Authenticator.login(userInput);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public static void run(User user) {
        while (true) {
            System.out.println(Message.MENU);
            int option = Integer.parseInt(scanner.nextLine());

            if (Menu.validateOption(option)) {
                executeOption(option, user);
            } else {
                System.out.println(Message.VALID_OPTION);
            }
        }
    }

    public static void executeOption(int option, User user) {
        Menu menu = Menu.fromOption(option);
        menu.execute(user);
    }

}
