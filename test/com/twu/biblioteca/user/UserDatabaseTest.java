package com.twu.biblioteca.user;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.resource.DataProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserDatabaseTest {

  private DataProvider dataProvider;
  private User user;

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;

  @Before
  public void setUpData() {
    this.dataProvider = new DataProvider();
    user = new User("000-0001", "password", "Alex", "alex@gmail.com", "111-1111");
  }

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @Test
  public void should_print_user_info() {
    UserDatabase.viewUserInfo(user);
    assertThat(outContent.toString(), is("Alex | alex@gmail.com | 111-1111 | \n"));
  }

  @Test
  public void should_display_user_checkout_items() {
    Movie movie = new Movie("A Rainy Day in New York", 2019, "Woody Allen", 6.6);
    Book book = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997);
    UserDatabase.addItem(user, movie);
    UserDatabase.addItem(user, book);

    UserDatabase.viewItem(user);
    assertThat(outContent.toString(),
            is("A Rainy Day in New York | 2019 | Woody Allen | 6.6\n" +
                    "Harry Potter and the Philosopher's Stone | J. K. Rowling | 1997\n"));
  }

  @Test
  public void should_display_nothing_when_user_has_not_checkout_item() {
    UserDatabase.viewItem(user);
    assertThat(outContent.toString(), is("\n"));
  }

  @Test
  public void should_update_checkout_items_after_return() {
    Movie movie = new Movie("A Rainy Day in New York", 2019, "Woody Allen", 6.6);
    UserDatabase.addItem(user, movie);
    UserDatabase.removeItem(user, movie);

    UserDatabase.viewItem(user);
    assertThat(outContent.toString(), is("\n"));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

}