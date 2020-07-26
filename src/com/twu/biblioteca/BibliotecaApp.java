package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        startApplication(scanner);
        scanner.close();
    }

    public static void startApplication(Scanner scanner) {
        System.out.println(Message.WELCOME);
        boolean flag = true;

        while (flag) {
            System.out.println(Message.MENU);
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.println(BookList.printBookList());
                    break;

                case "2":
                    System.out.println(Message.CHECKOUT_HINT);
                    String checkoutBookName = scanner.nextLine();

                    if (checkoutBook(checkoutBookName)) {
                        System.out.println(Message.CHECKOUT_SUCCESS);
                    } else {
                        System.out.println(Message.CHECKOUT_FAILURE);
                    }
                    break;

                case "3":
                    System.out.println(Message.RETURN_HINT);
                    String returnBookName = scanner.nextLine();

                    if (returnBook(returnBookName)) {
                        System.out.println(Message.RETURN_SUCCESS);
                    } else {
                        System.out.println(Message.RETURN_FAILURE);
                    }
                    break;

                case "4":
                    flag = false;
                    break;

                default:
                    System.out.println("Please select a valid option!");
            }
        }
    }

    public static boolean checkoutBook(String bookName) {
        if (BookList.isBookAvailable(bookName)) {
            BookList.changeBookStatus(bookName);
            return true;
        }
        return false;
    }

    public static boolean returnBook(String bookName) {
        if (BookList.isBookBelongToLibrary(bookName)) {
            BookList.changeBookStatus(bookName);
            return true;
        }
        return false;
    }

}
