package com.twu.biblioteca.entity;

import java.util.Objects;

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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Movie movie = (Movie) o;
    return year == movie.year &&
            Objects.equals(name, movie.name) &&
            Objects.equals(director, movie.director) &&
            Objects.equals(rating, movie.rating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, year, director, rating);
  }

  @Override
  public String toString() {
    return name + " | " + year + " | " + director + " | " + rating;
  }

}
