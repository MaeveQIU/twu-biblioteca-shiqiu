package com.twu.biblioteca.resource;

public final class Message {
  public static final String WELCOME = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
  public static final String MENU = "1. List of books\n2. Checkout a book\n3. Return a book\n4. List of movies\n" +
          "5. Checkout a movie\n6. Return a movie\n7. View checkout books\n8. View my information \n9. Quit";
  public static final String CHECKOUT_HINT = "Input the item name that you want to checkout.";
  public static final String CHECKOUT_SUCCESS = "Thank you! Enjoy it.";
  public static final String CHECKOUT_FAILURE = "Sorry, this is not available.";
  public static final String RETURN_HINT = "Input the item name that you want to return.";
  public static final String RETURN_SUCCESS = "Thank you for returning it.";
  public static final String RETURN_FAILURE = "That is not a valid item to return.";
  public static final String VALID_OPTION = "Please select a valid option!";
  public static final String USER_LOGIN = "Please input your credential in the format of 'library number,password', e.g. xxx-xxxx,xxx";
  public static final String LOGIN_SUCCESS = "You have successfully logged in.";
  public static final String LOGIN_FAILURE = "Sorry, you haven't signed up yet.";
}
