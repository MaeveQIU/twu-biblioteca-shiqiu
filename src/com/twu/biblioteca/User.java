package com.twu.biblioteca;

import java.util.Objects;

public class User {

  private String libraryNumber;
  private String password;

  public User(String libraryNumber, String password) {
    this.libraryNumber = libraryNumber;
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return Objects.equals(libraryNumber, user.libraryNumber) &&
            Objects.equals(password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(libraryNumber, password);
  }
}
