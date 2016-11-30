package com.makarevich.command;

import com.makarevich.beans.User;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.MessageConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.UserDAO;
import com.makarevich.filter.UserType;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;
import com.makarevich.managers.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Locale;

public class LoginCommand extends ActionCommand {

  private Logger logger = Logger.getRootLogger();

  @Override
  public boolean checkAccess(User user) {
    return true;
  }

  @Override
  public String execute(HttpServletRequest request) {
    String page = null;
    Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
    String email = request.getParameter(Parameters.USER_EMAIL);
    String pass = request.getParameter(Parameters.USER_PASSWORD);
    // проверка логина и пароля

    try {
      if(UserDAO.INSTANCE.isAuthorized(email, pass)){
        HttpSession session = request.getSession();
        User user = UserDAO.INSTANCE.getUserByEmail(email);
        UserType userType= UserDAO.INSTANCE.getUserRole(email);
          session.setAttribute(Parameters.USER_ROLE_ID,userType);
          session.setAttribute(Parameters.USER, user);
        logger.info("Successful authentication by email: " + email);
          if(UserType.USER.equals(userType)){
              page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.CLIENT_PAGE_PATH);
        } else if (UserType.ADMIN.equals(userType)){
              page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
        } else  if (UserType.WAITER.equals(userType)){
            page= ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.WAITER_PAGE_PATH);
          }
      } else{
        logger.info("Authentication fail by email: " + email);
        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        request.setAttribute(Parameters.ERROR_LOGIN_OR_PASSWORD, MessageManager.INSTANCE.getMessage(MessageConstants.WRONG_LOGIN_OR_PASSWORD,locale));
      }
    }
    catch (SQLException e) {
     // PaymentSystemLogger.INSTANCE.logError(getClass(), e.getMessage());
      page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
      request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getMessage(MessageConstants.ERROR_DATABASE,locale));
    }
    return page;
  }
}
