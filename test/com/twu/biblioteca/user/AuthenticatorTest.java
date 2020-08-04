package com.twu.biblioteca.user;

import com.twu.biblioteca.resource.DataProvider;
import com.twu.biblioteca.resource.Message;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AuthenticatorTest {

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
  public void should_return_user_from_string() {
    assertThat(Authenticator.getUserByString("000-0001,password"), is(user));
  }

  @Test
  public void should_print_login_success_message_with_the_right_credential() {
    Authenticator.login("000-0001,password");
    assertThat(outContent.toString(), is(Message.LOGIN_SUCCESS + "\n"));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

}