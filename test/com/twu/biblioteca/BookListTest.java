package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class BookListTest {

  private String PHILOSOPHER_STONE;
  private String GOBLET_OF_FIRE;

  @Before
  public void setUp() {
    PHILOSOPHER_STONE = "Harry Potter and the Philosopher's Stone";
    GOBLET_OF_FIRE = "Harry Potter and the Goblet of Fire";
    BookList.resetAllBooks();
  }

  @Test
  public void should_display_three_default_books_after_initialization() {
    assertThat(BookList.printBookList().split("\n").length, is(3));
  }

  @Test
  public void should_contain_author_and_year_on_books() {
    String book = BookList.printBookList().split("\n")[0];

    assertThat(book, containsString("J. K. Rowling"));
    assertThat(book, containsString("199"));
  }

  @Test
  public void should_display_two_books_after_checkout_one() {
    BookList.changeBookStatus(PHILOSOPHER_STONE);
    assertThat(BookList.printBookList().split("\n").length, is(2));
  }

  @Test
  public void should_return_false_when_book_is_not_available() {
    boolean isBookAvailable = BookList.isBookAvailable(GOBLET_OF_FIRE);
    assertThat(isBookAvailable, is(false));
  }

  @Test
  public void should_display_three_books_after_return_one() {
    BookList.changeBookStatus(PHILOSOPHER_STONE);
    BookList.changeBookStatus(PHILOSOPHER_STONE);
    assertThat(BookList.printBookList().split("\n").length, is(3));
  }

//  @Test
//  public void should_return_false_when_book_does_not_belong_to_library() {
//    boolean isBookBelongToLibrary = BookList.isBookBelongToLibrary(GOBLET_OF_FIRE);
//    assertThat(isBookBelongToLibrary, is(false));
//  }

}