package com.twu.biblioteca;

import java.util.Map;

public class PrintCommand implements Command {

  private Map<?, Boolean> itemList;

  public PrintCommand(Map<?, Boolean> itemList) {
    this.itemList = itemList;
  }

  @Override
  public void execute() {
    Library.print((Map<Item, Boolean>) itemList);
  }
}

