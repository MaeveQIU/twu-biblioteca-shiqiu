package com.twu.biblioteca.command;

import com.twu.biblioteca.user.User;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Library;

import java.util.Map;

public class PrintCommand implements Command {

  private Map<? extends Item, Boolean> itemList;

  public PrintCommand(Map<? extends Item, Boolean> itemList) {
    this.itemList = itemList;
  }

  @Override
  public void execute(User user) {
    Library.print(itemList);
  }
}

