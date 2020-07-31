package com.twu.biblioteca;

import java.util.Scanner;

public class CheckoutCommand implements Command {

  @Override
  public void execute() {
    System.out.println(Message.CHECKOUT_HINT);
    Scanner scanner = new Scanner(System.in);
    String bookName = scanner.nextLine();

    if (Library.checkoutBook(bookName)) {
      System.out.println(Message.CHECKOUT_SUCCESS);
    } else {
      System.out.println(Message.CHECKOUT_FAILURE);
    }
  }
}
