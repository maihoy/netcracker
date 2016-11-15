package com.makarevich.command;

import com.makarevich.beans.User;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.MessageConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.UserDAO;
import com.makarevich.enums.Roles;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Set;

public class LoginCommand implements ActionCommand {

  @Override
  public String execute(HttpServletRequest request) {
    String page;
    String email = request.getParameter(Parameters.USER_EMAIL);
    String pass = request.getParameter(Parameters.USER_PASSWORD);
    // проверка логина и пароля

    try {
      if(UserDAO.isAuthorized(email, pass)){
        HttpSession session = request.getSession();
        User user = UserDAO.getUserByEmail(email);
        Set<Roles> roles;
        roles= UserDAO.checkAccessLevel(email);
        for (Roles r : roles) {
          session.setAttribute(Parameters.USER_ROLE_TYPE, r);
        }
        session.setAttribute(Parameters.USER, user);
        if(Roles.USER.equals(user.getRoles())){
          page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.CLIENT_PAGE_PATH);
        }
        else{
          page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
        }
      }
      else{
        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD, MessageManager.INSTANCE.getProperty(MessageConstants.WRONG_LOGIN_OR_PASSWORD));
      }
    }
    catch (SQLException e) {
     // PaymentSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
      page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
      request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
    }
    return page;
  }
}
