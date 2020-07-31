package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public final class BookList {

  private static Map<Book, Boolean> bookList;

  static {
    bookList = new HashMap<>();
    bookList.put(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997), true);
    bookList.put(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998), true);
    bookList.put(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 1999), true);
  }

  public static Book getBookByName(String bookName) {
    for (Book book : bookList.keySet()) {
      if (book.getName().equals(bookName)) {
        return book;
      }
    }
    return null;
  }

  public static boolean isBookAvailable(String bookName) {
    Book book = getBookByName(bookName);
    if (book != null) {
      return bookList.get(book);
    }
    return false;
  }

  public static void changeBookStatus(String bookName) {
    Book book = getBookByName(bookName);
    if (book != null) {
      bookList.replace(book, !bookList.get(book));
    }
  }

  public static String printBookList() {
    return bookList.keySet()
            .stream()
            .filter(book -> bookList.get(book))
            .map(Book::toString)
            .collect(Collectors.joining("\n"));
  }

  public static void resetAllBooks() {
    bookList.replaceAll((book, value) -> true);
  }

}
