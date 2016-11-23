package com.makarevich.command.factory;

import com.makarevich.command.ActionCommand;
import com.makarevich.command.LoginCommand;
import com.makarevich.constants.Parameters;

import javax.servlet.http.HttpServletRequest;

public enum  ActionFactory {
  INSTANCE;

  public ActionCommand defineCommand(HttpServletRequest request) {
    ActionCommand current;
    String action = request.getParameter(Parameters.COMMAND);
    try{
      CommandEnum type = CommandEnum.valueOf(action.toUpperCase());
      current = type.getCurrentCommand();
    }
    catch(NullPointerException e){
      current = new LoginCommand();
    }
    catch(IllegalArgumentException e){
      current = new LoginCommand();
    }
    return current;
  }
}