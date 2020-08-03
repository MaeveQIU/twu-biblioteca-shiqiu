package com.twu.biblioteca.user;

import com.twu.biblioteca.resource.Message;

import java.io.PrintStream;
import java.util.Set;

public final class Authenticator {

  private static PrintStream printer = System.out;
  private static Set<User> userList;

  static {
    userList = UserDatabase.getUserDatabase().keySet();
  }

  public static User login(String userInput) {
    User user = getUserByString(userInput);
    if (user != null) {
      if (!verifyUser(user)) {
        printer.println(Message.LOGIN_FAILURE);
        System.exit(0);
      } else {
        printer.println(Message.LOGIN_SUCCESS);
        return user;
      }
    }
    return null;
  }

  public static User getUserByString(String userInput) {
    String[] infoList = userInput.split(",");
    User tempUser = new User(infoList[0], infoList[1]);
    for (User user : userList) {
      if (user.equals(tempUser)) {
        return user;
      }
    }
    return null;
  }

  public static boolean verifyUser(User user) {
    return userList.contains(user);
  }

}
