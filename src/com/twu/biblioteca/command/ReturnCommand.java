package com.twu.biblioteca.command;

import com.twu.biblioteca.resource.Message;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.user.UserDatabase;

import java.util.Map;
import java.util.Scanner;

public class ReturnCommand implements Command {

  private Map<? extends Item, Boolean> itemList;

  private Scanner scanner = new Scanner(System.in);

  public ReturnCommand(Map<? extends Item, Boolean> itemList) {
    this.itemList = itemList;
  }

  @Override
  public void execute(User user) {
    System.out.println(Message.RETURN_HINT);
    String name = scanner.nextLine();

    if (Library.returnItem(itemList, name)) {
      UserDatabase.removeItem(user, Library.getItemByName(itemList, name));
      System.out.println(Message.RETURN_SUCCESS);
    } else {
      System.out.println(Message.RETURN_FAILURE);
    }

  }
}
