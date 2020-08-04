package com.twu.biblioteca.entity;

import com.twu.biblioteca.resource.DataProvider;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

  private DataProvider dataProvider;

  @Before
  public void setUpData() {
    this.dataProvider = new DataProvider();
  }

  @Test
  public void should_initialize_with_three_items_each() {
    assertThat(Library.getBookList().size(), is(3));
    assertThat(Library.getMovieList().size(), is(3));
  }

  @Test
  public void should_return_item_from_string() {
    Movie movie = new Movie("A Rainy Day in New York", 2019, "Woody Allen", 6.6);
    assertThat(Library.getItemByName(Library.getMovieList(), "A Rainy Day in New York"), is(movie));
  }

  @Test
  public void should_change_status_after_checkout_and_return() {
    Library.checkoutItem(Library.getMovieList(), "A Rainy Day in New York");
    boolean checkoutItemAvailable = Library.isItemAvailable(Library.getMovieList(), "A Rainy Day in New York");
    assertThat(checkoutItemAvailable, is(false));

    Library.returnItem(Library.getMovieList(), "A Rainy Day in New York");
    boolean returnItemAvailable = Library.isItemAvailable(Library.getMovieList(), "A Rainy Day in New York");
    assertThat(returnItemAvailable, is(true));
  }

  @Test
  public void should_return_false_when_item_not_belong_to_the_right_list() {
    boolean itemCanBeReturn = Library.returnItem(Library.getBookList(), "A Rainy Day in New York");
    assertThat(itemCanBeReturn, is(false));
  }

  @Test
  public void should_return_false_when_item_have_not_been_checkout() {
    boolean itemCanBeReturn = Library.returnItem(Library.getMovieList(), "A Rainy Day in New York");
    assertThat(itemCanBeReturn, is(false));
  }

}