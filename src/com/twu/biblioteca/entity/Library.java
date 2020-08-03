package com.twu.biblioteca.entity;

import java.io.PrintStream;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Library {

  private static Map<Book, Boolean> bookList;
  private static Map<Movie, Boolean> movieList;

  private static PrintStream printer = System.out;

  public static void print(Map<? extends Item, Boolean> itemList) {
    String result = itemList.keySet().stream().filter(itemList::get).map(Object::toString)
            .collect(Collectors.joining("\n"));
    printer.println(result);
  }

  public static boolean checkoutItem(Map<? extends Item, Boolean> itemList, String name) {
    if (isItemAvailable(itemList, name)) {
      changeItemStatus(itemList, name);
      return true;
    }
    return false;
  }

  public static boolean returnItem(Map<? extends Item, Boolean> itemList, String name) {
    if (isItemValid(itemList, name)) {
      changeItemStatus(itemList, name);
      return true;
    }
    return false;
  }

  public static Item getItemByName(Map<? extends Item, Boolean> itemList, String name) {
    return itemList.keySet().stream().filter(key -> key.getName().equals(name)).findFirst().orElse(null);
  }

  public static boolean isItemAvailable(Map<? extends Item, Boolean> itemList, String name) {
    Item item = getItemByName(itemList, name);
    return Optional.ofNullable(itemList.get(item)).orElse(false);
  }

  public static boolean isItemValid(Map<? extends Item, Boolean> itemList, String name) {
    Item item = getItemByName(itemList, name);
    if (item != null) {
      return !itemList.get(item);
    }
    return false;
  }

  public static void changeItemStatus(Map<? extends Item, Boolean> itemList, String name) {
    Optional.ofNullable(getItemByName(itemList, name)).ifPresent((item) -> {
      if (item.getClass().equals(Book.class)) {
        Optional.ofNullable((Book) getItemByName(bookList, name)).ifPresent(book -> bookList.replace(book, !bookList.get(book)));
      } else if (item.getClass().equals(Movie.class)) {
        Optional.ofNullable((Movie) getItemByName(movieList, name)).ifPresent(movie -> movieList.replace(movie, !movieList.get(movie)));
      }
    });
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

}
