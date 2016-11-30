package com.makarevich.command.admin;

import com.makarevich.beans.User;
import com.makarevich.command.AdminCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.UserDAO;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

/**
 * Created by j on 20.11.16.
 */
public class ShowAllUsersCommand extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        HttpSession session= request.getSession();
        try {
                List<User> users=UserDAO.INSTANCE.findAll();
                session.setAttribute(Parameters.USER_LIST, users);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_SHOW_ALL_USERS_PAGE);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return page;
    }
}
