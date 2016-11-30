package com.makarevich.command.admin;

import com.makarevich.beans.User;
import com.makarevich.command.AdminCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.UserDAO;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by j on 22.11.16.
 */
public class DeleteUserCommand extends AdminCommand {
    private static String email;
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        email=request.getParameter(Parameters.USER_EMAIL);
        try {
            User user=UserDAO.INSTANCE.getUserByEmail(email);
            if(!UserDAO.INSTANCE.isNewUser(user.getEmail()))    {
                UserDAO.INSTANCE.deleteEntity(user.getId(),user.getEmail());
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.WAITER_SHOW_ALL_DISHES_PATH);
            }else {
                page=ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
            }
        } catch (SQLException e) {
            System.out.println(e);

        }
        return page;
    }
}
