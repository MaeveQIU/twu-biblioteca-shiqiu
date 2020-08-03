package com.twu.biblioteca.resource;


import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;
import com.twu.biblioteca.command.CheckoutCommand;
import com.twu.biblioteca.command.Command;
import com.twu.biblioteca.command.PrintCommand;
import com.twu.biblioteca.command.ReturnCommand;
import com.twu.biblioteca.entity.Library;

import java.util.Arrays;
import java.util.Optional;

public enum Menu {
  PRINT_BOOK(1, Optional.of(new PrintCommand(Library.getBookList()))),
  CHECKOUT_BOOK(2, Optional.of(new CheckoutCommand(Library.getBookList()))),
  RETURN_BOOK(3, Optional.of(new ReturnCommand(Library.getBookList()))),
  PRINT_MOVIE(4, Optional.of(new PrintCommand(Library.getMovieList()))),
  CHECKOUT_MOVIE(5, Optional.of(new CheckoutCommand(Library.getMovieList()))),
  RETURN_MOVIE(6, Optional.of(new ReturnCommand(Library.getMovieList()))),
  VIEW_CHECKOUTS(7, Optional.empty()) {
    @Override
    public void execute(User user) {
      UserDatabase.viewItem(user);
    }
  },
  VIEW_INFO(8, Optional.empty()) {
    @Override
    public void execute(User user) {
      UserDatabase.viewUserInfo(user);
    }
  },
  QUIT(9, Optional.empty()) {
    @Override
    public void execute(User user) {
      System.exit(0);
    }
  };

  private int option;
  private Optional<Command> command;

  Menu(int option, Optional<Command> command) {
    this.option = option;
    this.command = command;
  }

  public static boolean validateOption(int option) {
    return Arrays.stream(Menu.values()).anyMatch(v -> v.option == option);
  }

  public static Menu fromOption(int option) {
    return Arrays.stream(Menu.values()).filter(value -> value.option == option).findFirst().get();
  }

  public void execute(User user) {
    this.command.get().execute(user);
  }

}
