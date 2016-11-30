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
import java.util.Locale;

/**
 * Created by j on 22.11.16.
 */
public class GoToUpdateCommand extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        String uemailToEdit=request.getParameter(Parameters.USER_EMAIL);
        HttpSession session= request.getSession();
        String page =null;
        try {
                User userToEdit= UserDAO.INSTANCE.getUserByEmail(uemailToEdit);
                session.setAttribute(Parameters.USER_TO_EDIT, userToEdit);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.UPDATE_PAGE_PATH);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
