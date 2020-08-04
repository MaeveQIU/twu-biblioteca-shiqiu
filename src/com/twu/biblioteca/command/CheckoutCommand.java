package com.twu.biblioteca.command;

import com.twu.biblioteca.resource.Message;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Library;

import java.util.Map;
import java.util.Scanner;

public class CheckoutCommand implements Command {

  private Map<? extends Item, Boolean> itemList;

  private Scanner scanner = new Scanner(System.in);

  public CheckoutCommand(Map<? extends Item, Boolean> itemList) {
    this.itemList = itemList;
  }

  @Override
  public void execute(User user) {
    System.out.println(Message.CHECKOUT_HINT);
    String name = scanner.nextLine();

    if (Library.checkoutItem(itemList, name)) {
      UserDatabase.addItem(user, Library.getItemByName(itemList, name));
      System.out.println(Message.CHECKOUT_SUCCESS);
    } else {
      System.out.println(Message.CHECKOUT_FAILURE);
    }
  }
}
