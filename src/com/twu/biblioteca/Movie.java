package com.twu.biblioteca;

public class Movie extends Item {

  private String name;
  private int year;
  private String director;
  private Double rating;

  public Movie(String name, int year, String director, Double rating) {
    this.name = name;
    this.year = year;
    this.director = director;
    this.rating = rating;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name + " | " + year + " | " + director + " | " + rating;
  }

}
