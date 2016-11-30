package com.makarevich.command;
import com.makarevich.beans.User;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
public class LogoutCommand extends ActionCommand {
 @Override
 public boolean checkAccess(User user) {
  return true;
 }

 @Override
public String execute(HttpServletRequest request) {
 String page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
 // уничтожение сессии
 request.getSession().invalidate();
 return page;
}
}