package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public final class UserDatabase {

  private static Map<User, Item> userList;

  static {
    userList = new HashMap<>();
    userList.put(new User("111-1111", "abc", "A", "a@gmail.com", "111-1111"), null);
    userList.put(new User("222-2222", "def"), null);
    userList.put(new User("333-3333", "ghi"), null);
  }

  public static boolean verifyUser(User user) {
    return userList.containsKey(user);
  }

  public static void addItem(User user, Item item) {
    userList.replace(user, item);
  }

  public static void viewItem(User user) {
    System.out.println(userList.get(user));
  }

  public static void viewUserInfo(User user) {
    for (User key : userList.keySet()) {
      if (key.equals(user)) {
        System.out.println(key);
      }
    }
  }

}
