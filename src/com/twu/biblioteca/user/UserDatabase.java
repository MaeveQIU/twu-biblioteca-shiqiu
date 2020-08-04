package com.twu.biblioteca.user;

import com.twu.biblioteca.entity.Item;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public final class UserDatabase {

  private static Map<User, List<Item>> userDatabase;
  private static PrintStream printer = System.out;

  public static void addItem(User user, Item item) {
    userDatabase.get(userDatabase.keySet().stream().filter(key -> key.equals(user)).findFirst().get()).add(item);
  }

  public static void removeItem(User user, Item item) {
    userDatabase.get(userDatabase.keySet().stream().filter(key -> key.equals(user)).findFirst().get()).remove(item);
  }

  public static void viewItem(User user) {
    printer.println(userDatabase.get(user).stream().map(Object::toString).collect(Collectors.joining("\n")));
  }

  public static void viewUserInfo(User user) {
    userDatabase.keySet().stream().filter(key -> key.equals(user)).findFirst().ifPresent((key) -> printer.println(key));
  }

  public static Set<User> getUserDatabase() { return userDatabase.keySet(); }

  public static void setUserDatabase(Map<User, List<Item>> userList) {
    UserDatabase.userDatabase = userList;
  }

}
