package com.twu.biblioteca;

import java.util.Map;
import java.util.Scanner;

public class CheckoutCommand implements Command {

  private Map<?, Boolean> itemList;

  public CheckoutCommand(Map<?, Boolean> itemList) {
    this.itemList = itemList;
  }

  @Override
  public void execute(User user) {
    System.out.println(Message.CHECKOUT_HINT);
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();

    if (Library.checkoutItem((Map<Item, Boolean>) itemList, name)) {
      UserDatabase.addItem(user, Library.getItemByName((Map<Item, Boolean>) itemList, name));
      System.out.println(Message.CHECKOUT_SUCCESS);
    } else {
      System.out.println(Message.CHECKOUT_FAILURE);
    }
  }
}
