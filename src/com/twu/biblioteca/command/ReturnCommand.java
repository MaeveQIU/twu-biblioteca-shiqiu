package com.twu.biblioteca.command;

import com.twu.biblioteca.resource.Message;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Library;

import java.util.Map;
import java.util.Scanner;

public class ReturnCommand implements Command {

  private Map<?, Boolean> itemList;

  public ReturnCommand(Map<?, Boolean> itemList) {
    this.itemList = itemList;
  }

  @Override
  public void execute(User user) {
    System.out.println(Message.RETURN_HINT);
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();

    if (Library.returnItem((Map<Item, Boolean>) itemList, name)) {
      System.out.println(Message.RETURN_SUCCESS);
    } else {
      System.out.println(Message.RETURN_FAILURE);
    }

  }
}
