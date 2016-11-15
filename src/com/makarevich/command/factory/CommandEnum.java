package com.makarevich.command.factory;

import com.makarevich.command.ActionCommand;
import com.makarevich.command.LoginCommand;
import com.makarevich.command.LogoutCommand;
import com.makarevich.command.ShowMenuCommand;

public enum CommandEnum {
LOGIN ,LOGOUT , SHOW_MENU;

public ActionCommand getCurrentCommand() throws  EnumConstantNotPresentException {
 switch (this){
  case LOGIN:
   return new LoginCommand();

  case LOGOUT:
   return new LogoutCommand();

  case  SHOW_MENU:
   return new ShowMenuCommand();

  default:
   throw new EnumConstantNotPresentException(this.getDeclaringClass(),this.name());
 }
}

}