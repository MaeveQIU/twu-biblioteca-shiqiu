package com.twu.biblioteca.user;

import com.twu.biblioteca.entity.Item;

import java.util.Map;

public final class UserDatabase {

  private static Map<User, Item> userDatabase;

  public static void addItem(User user, Item item) {
    userDatabase.replace(user, item);
  }

  public static void viewItem(User user) {
    System.out.println(userDatabase.get(user));
  }

  public static void viewUserInfo(User user) {
    for (User key : userDatabase.keySet()) {
      if (key.equals(user)) {
        System.out.println(key);
      }
    }
  }

  public static Map<User, Item> getUserDatabase() {
    return userDatabase;
  }

  public static void setUserDatabase(Map<User, Item> userList) {
    UserDatabase.userDatabase = userList;
  }

}
