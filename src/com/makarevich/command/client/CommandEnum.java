package com.makarevich.command.client;

import com.makarevich.command.ActionCommand;
import com.makarevich.command.LoginCommand;
import com.makarevich.command.LogoutCommand;
import com.makarevich.command.ShowMenuCommand;

public enum CommandEnum {
LOGIN {
 {
 this.command = new LoginCommand();
 }
},
LOGOUT {
 {
 this.command = new LogoutCommand();
 }
},
 SHOW_MENU{
  {this.command= new ShowMenuCommand();}
 };
ActionCommand command;
public ActionCommand getCurrentCommand() {
 return command;
}
}