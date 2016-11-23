package com.makarevich.command.factory;

import com.makarevich.command.*;
import com.makarevich.command.admin.DeleteUserCommand;
import com.makarevich.command.admin.GoToUpdateCommand;
import com.makarevich.command.admin.ShowAllUsersCommand;
import com.makarevich.command.admin.UpdateUserCommand;

public enum CommandEnum {
LOGIN ,LOGOUT , REGISTRATION, GOTOREGISTRATION, SHOW_MENU, SHOW_USERS, DELETE_USER, UPDATE_USER, GOTOUPDATE;

public ActionCommand getCurrentCommand() throws  EnumConstantNotPresentException {
 switch (this){
  case LOGIN:
   return new LoginCommand();

  case LOGOUT:
   return new LogoutCommand();

  case REGISTRATION:
   return new RegistrationCommand();

  case GOTOREGISTRATION:
   return new GoToRegistrationCommand();

  case  SHOW_MENU:
   return new ShowMenuCommand();

  case SHOW_USERS:
   return new ShowAllUsersCommand();

  case DELETE_USER:
   return new DeleteUserCommand();

  case UPDATE_USER:
   return  new UpdateUserCommand();

  case GOTOUPDATE:
   return new GoToUpdateCommand();

  default:
   throw new EnumConstantNotPresentException(this.getDeclaringClass(),this.name());
 }
}

}