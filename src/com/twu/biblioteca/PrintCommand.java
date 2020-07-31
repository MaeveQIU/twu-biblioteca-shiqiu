package com.twu.biblioteca;

public class PrintCommand implements Command {

  @Override
  public void execute() {
    Library.print();
  }
}
