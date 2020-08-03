package com.twu.biblioteca.entity;

public class Book extends Item {

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
  public String toString() {
    return name + " | " + author + " | " + year;
  }
}
