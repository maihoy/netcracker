package com.makarevich.command;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
public class EmptyCommand implements ActionCommand {
@Override
public String execute(HttpServletRequest request) {
 /* в случае ошибки или прямого обращения к контроллеру
  * переадресация на страницу ввода логина */
 return ConfigurationManager.INSTANCE.getProperty("path.page.login");
}
}