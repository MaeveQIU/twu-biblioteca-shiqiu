package com.twu.biblioteca.entity;

import java.util.Map;
import java.util.stream.Collectors;

public final class Library {

  private static Map<Book, Boolean> bookList;
  private static Map<Movie, Boolean> movieList;

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
    if (isItemValid(itemList, name)) {
      changeItemStatus(itemList, name);
      return true;
    }
    return false;
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
    if (item != null) {
      return !itemList.get(item);
    }
    return false;
  }

  public static void changeItemStatus(Map<Item, Boolean> itemList, String name) {
    Item item = getItemByName(itemList, name);
    if (item != null) {
      itemList.replace(item, !itemList.get(item));
    }
  }

  public static Map<Book, Boolean> getBookList() {
    return bookList;
  }

  public static Map<Movie, Boolean> getMovieList() {
    return movieList;
  }

  public static void setBookList(Map<Book, Boolean> bookList) {
    Library.bookList = bookList;
  }

  public static void setMovieList(Map<Movie, Boolean> movieList) {
    Library.movieList = movieList;
  }

  public static void resetAll(Map<Item, Boolean> itemList) {
    itemList.replaceAll((item, value) -> true);
  }

}
