package com.twu.biblioteca.command;

import com.twu.biblioteca.user.User;

public interface Command {

  void execute(User user);

}
