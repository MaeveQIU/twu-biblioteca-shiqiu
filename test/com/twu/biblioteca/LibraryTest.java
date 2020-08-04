package com.twu.biblioteca;

import com.twu.biblioteca.resource.DataProvider;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

public class LibraryTest {

  private String PHILOSOPHER_STONE;
  private String GOBLET_OF_FIRE;
  private DataProvider dataProvider = new DataProvider();

  @Before
  public void setUp() {
    PHILOSOPHER_STONE = "Harry Potter and the Philosopher's Stone";
    GOBLET_OF_FIRE = "Harry Potter and the Goblet of Fire";
  }
}