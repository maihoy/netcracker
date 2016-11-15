package com.makarevich.command.factory;

import com.makarevich.command.ActionCommand;
import com.makarevich.command.EmptyCommand;
import com.makarevich.command.LoginCommand;
import com.makarevich.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

public enum  ActionFactory {
  INSTANCE;

  public ActionCommand defineCommand(HttpServletRequest request) {
    ActionCommand current = new EmptyCommand();
    String action = request.getParameter(Parameters.COMMAND);
    if (action == null || action.isEmpty()) {
      return current;
    }
    try {
      CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
      current = currentEnum.getCurrentCommand();
    } catch (IllegalArgumentException | NullPointerException e) {
      current= new LoginCommand();
    }
    return current;
  }
}