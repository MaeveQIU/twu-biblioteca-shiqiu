package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class Library {

  private static Map<Book, Boolean> bookList;
  private static Map<Movie, Boolean> movieList;

  static {
    bookList = new HashMap<>();
    bookList.put(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997), true);
    bookList.put(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998), true);
    bookList.put(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 1999), true);

    movieList = new HashMap<>();
    movieList.put(new Movie("A Rainy Day in New York", 2019, "Woody Allen", 6.6), true);
    movieList.put(new Movie("Call Me by Your Name", 2017, "Luca Guadagnino", 7.9), true);
    movieList.put(new Movie("Wonder Wheel", 2017, "Woody Allen", 6.2), true);
  }

  public static void print(Map<Item, Boolean> itemList) {
    String result = itemList.keySet()
            .stream()
            .filter(itemList::get)
            .map(Object::toString)
            .collect(Collectors.joining("\n"));
    System.out.println(result);
  }

  public static boolean checkoutItem(Map<Item, Boolean> itemList, String name) {
    if (isItemAvailable(itemList, name)) {
      changeItemStatus(itemList, name);
      return true;
    }
    return false;
  }

  public static boolean returnItem(Map<Item, Boolean> itemList, String name) {
    if (isItemAvailable(itemList, name)) {
      changeItemStatus(itemList, name);
      return true;
    }
    return false;
  }

  public static Map<Book, Boolean> getBookList() {
    return bookList;
  }

  public static Map<Movie, Boolean> getMovieList() {
    return movieList;
  }

  public static Item getItemByName(Map<Item, Boolean> itemList, String name) {
    for (Item item : itemList.keySet()) {
      if (item.getName().equals(name)) {
        return item;
      }
    }
    return null;
  }

  public static boolean isItemAvailable(Map<Item, Boolean> itemList, String name) {
    Item item = getItemByName(itemList, name);
    if (item != null) {
      return itemList.get(item);
    }
    return false;
  }

  public static boolean isItemValid(Map<Item, Boolean> itemList, String name) {
    Item item = getItemByName(itemList, name);
    return item != null & !itemList.get(item);
  }

  public static void changeItemStatus(Map<Item, Boolean> itemList, String name) {
    Item item = getItemByName(itemList, name);
    if (item != null) {
      itemList.replace(item, !itemList.get(item));
    }
  }

  public static void resetAll(Map<Item, Boolean> itemList) {
    itemList.replaceAll((item, value) -> true);
  }

}
