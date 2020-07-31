package com.twu.biblioteca;

import java.util.Scanner;

public class ReturnCommand implements Command {

  @Override
  public void execute() {
    System.out.println(Message.RETURN_HINT);
    Scanner scanner = new Scanner(System.in);
    String bookName = scanner.nextLine();

    if (Library.returnBook(bookName)) {
      System.out.println(Message.RETURN_SUCCESS);
    } else {
      System.out.println(Message.RETURN_FAILURE);
    }

  }
}
