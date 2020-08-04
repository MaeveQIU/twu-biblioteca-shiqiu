package com.twu.biblioteca.resource;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Item;
import com.twu.biblioteca.entity.Library;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.user.User;
import com.twu.biblioteca.user.UserDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

  public DataProvider() {
    initUserDatabase();
    initLibrary();
  }

  public void initUserDatabase() {
    Map<User, List<Item>> userDatabase = new HashMap<>();
    userDatabase.put(new User("000-0001", "password", "Alex", "alex@gmail.com", "111-1111"), new ArrayList<>());
    userDatabase.put(new User("000-0002", "password"), new ArrayList<>());
    userDatabase.put(new User("000-0003", "password"), new ArrayList<>());
    UserDatabase.setUserDatabase(userDatabase);
  }

  public void initLibrary() {
    Map<Book, Boolean> bookList = new HashMap<>();
    bookList.put(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997), true);
    bookList.put(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998), true);
    bookList.put(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 1999), true);
    Library.setBookList(bookList);

    Map<Movie, Boolean> movieList = new HashMap<>();
    movieList.put(new Movie("A Rainy Day in New York", 2019, "Woody Allen", 6.6), true);
    movieList.put(new Movie("Call Me by Your Name", 2017, "Luca Guadagnino", 7.9), true);
    movieList.put(new Movie("Wonder Wheel", 2017, "Woody Allen", 6.2), true);
    Library.setMovieList(movieList);
  }

}
