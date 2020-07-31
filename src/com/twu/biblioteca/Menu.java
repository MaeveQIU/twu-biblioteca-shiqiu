package com.twu.biblioteca;


import java.util.Arrays;
import java.util.Optional;

public enum Menu {
  PRINT(1, Optional.of(new PrintCommand())),
  CHECKOUT(2, Optional.of(new CheckoutCommand())),
  RETURN(3, Optional.of(new ReturnCommand())),
  QUIT(4, Optional.empty()) {
    @Override
    public void execute(int option) {
      System.exit(0);
    }
  };

  private int option;
  private Optional<Command> command;

  Menu(int option, Optional<Command> command) {
    this.option = option;
    this.command = command;
  }

  public int getOption() { return option; }

  public Menu fromOption(int option) {
    return Arrays.stream(Menu.values()).filter(value -> value.option == option).findFirst().get();
  }

  public void execute(int option) {
    fromOption(option).command.get().execute();
  }
}
