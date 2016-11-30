package com.makarevich.command;
import com.makarevich.beans.User;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
public class EmptyCommand extends ActionCommand {
 @Override
 public boolean checkAccess(User user) {
  return true;
 }

 @Override
public String execute(HttpServletRequest request) {
 /* в случае ошибки или прямого обращения к контроллеру
  * переадресация на страницу ввода логина */
 return ConfigurationManager.INSTANCE.getProperty("path.page.login");
}
}