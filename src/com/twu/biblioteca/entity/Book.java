package com.twu.biblioteca.entity;

import java.util.Objects;

public class Book implements Item {

  private String name;
  private String author;
  private int year;

  public Book(String name, String author, int year) {
    this.name = name;
    this.author = author;
    this.year = year;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return year == book.year &&
            Objects.equals(name, book.name) &&
            Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, author, year);
  }

  @Override
  public String toString() {
    return name + " | " + author + " | " + year;
  }
}
