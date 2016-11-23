package com.makarevich.command.admin;

import com.makarevich.beans.User;
import com.makarevich.command.ActionCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.UserDAO;
import com.makarevich.filter.UserType;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by j on 20.11.16.
 */
public class ShowAllUsersCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        HttpSession session= request.getSession();
        try {
            UserType userType=(UserType) session.getAttribute(Parameters.USER_ROLE_ID);
            if(userType==UserType.ADMIN){
                List<User> users=UserDAO.INSTANCE.findAll();
                session.setAttribute(Parameters.USER_LIST, users);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_SHOW_ALL_USERS_PAGE);
            }
            else{
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                session.invalidate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return page;
    }
}
