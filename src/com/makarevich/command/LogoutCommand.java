package com.makarevich.command;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
public class LogoutCommand implements ActionCommand {
@Override
public String execute(HttpServletRequest request) {
 String page = ConfigurationManager.INSTANCE.getProperty("path.page.index");
 // уничтожение сессии
 request.getSession().invalidate();
 return page;
}
}