package com.twu.biblioteca;


import java.util.Arrays;
import java.util.Optional;

public enum Menu {
  PRINT_BOOK(1, Optional.of(new PrintCommand(Library.getBookList()))),
  CHECKOUT_BOOK(2, Optional.of(new CheckoutCommand(Library.getBookList()))),
  RETURN_BOOK(3, Optional.of(new ReturnCommand(Library.getBookList()))),
  PRINT_MOVIE(4, Optional.of(new PrintCommand(Library.getMovieList()))),
  CHECKOUT_MOVIE(5, Optional.of(new CheckoutCommand(Library.getMovieList()))),
  RETURN_MOVIE(6, Optional.of(new ReturnCommand(Library.getMovieList()))),
  QUIT(7, Optional.empty()) {
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
