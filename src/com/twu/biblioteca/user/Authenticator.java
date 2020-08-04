package com.twu.biblioteca.user;

import com.twu.biblioteca.resource.Message;

import java.io.PrintStream;
import java.util.Optional;
import java.util.Set;

public final class Authenticator {

  private static PrintStream printer = System.out;
  private static Set<User> userList;

  static {
    userList = UserDatabase.getUserDatabase();
  }

  public static User login(String userInput) {
    User user = getUserByString(userInput);
    Optional.ofNullable(user).orElseGet(() -> {
      printer.println(Message.LOGIN_FAILURE);
      System.exit(0);
      return null;
    });
    printer.println(Message.LOGIN_SUCCESS);
    return user;
  }

  public static User getUserByString(String userInput) {
    String[] infoList = userInput.split(",");
    User tempUser = new User(infoList[0], infoList[1]);
    return userList.stream().filter(user -> user.equals(tempUser)).findFirst().orElse(null);
  }

}
