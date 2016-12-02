package com.makarevich.command.factory;

import com.makarevich.command.*;
import com.makarevich.command.admin.*;
import com.makarevich.command.user.*;
import com.makarevich.command.waiter.*;

public enum CommandEnum {
 LOGIN ,LOGOUT , REGISTRATION, GOTOREGISTRATION,
 SHOW_USERS, DELETE_USER, UPDATE_USER, GOTOUPDATE,
 SHOW_MENU, GOTOEDITDISH, UPDATE_DISH, ADD_DISH, DELETE_DISH, GOTOADD_DISH,
 SHOW_ORDER, GOADDTO_ORDER, ADDTO_ORDER, DELETE_FROM_ORDER,
 BACKUSER, BACKWAITER, BACKADMIN, BACK;

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

  case GOTOEDITDISH:
   return new GoToEditMenuCommand();

  case UPDATE_DISH:
   return new UpdateDishCommand();

  case ADD_DISH:
   return new AddToMenuCommand();

  case GOTOADD_DISH:
   return new GoToAddDishCommand();

  case DELETE_DISH:
   return new DeleteDishCommand();

  case SHOW_ORDER:
   return new ShowOrderCommand();

  case ADDTO_ORDER:
   return new AddToOrder();

  case GOADDTO_ORDER:
   return new GoAddToOrder();

  case DELETE_FROM_ORDER:
   return new DeleteFromOrderCommand();

  case BACKUSER:
   return new ReturnUserPage();

  case BACKWAITER:
   return new ReturnWaiterPage();

  case BACKADMIN:
   return new ReturnAdminPage();

  case BACK:
   return new ReturnToIndex();

  default:
   throw new EnumConstantNotPresentException(this.getDeclaringClass(),this.name());
 }
}

}