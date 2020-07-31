package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Scanner;

public class BibliotecaApp {

    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Message.WELCOME);

        while (true) {
            System.out.println(Message.MENU);
            int option = Integer.parseInt(scanner.nextLine());

            if (validateOption(option)) {
                startApplication(option);
            } else {
                System.out.println(Message.VALID_OPTION);
            }
        }
    }

    public static void startApplication(int option) {
        for (Menu value : Menu.values()) {
            if (value.getOption() == option) {
                value.execute(option);
            }
        }
    }

    public static boolean validateOption(int option) {
        return Arrays.stream(Menu.values()).anyMatch(value -> value.getOption() == option);
    }

}
