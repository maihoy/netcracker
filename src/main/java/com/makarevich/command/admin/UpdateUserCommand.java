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
public class UpdateUserCommand extends AdminCommand {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String password;
    private static String role;
    private static String state;
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        firstName=request.getParameter(Parameters.USER_FIRST_NAME);
        lastName=request.getParameter(Parameters.USER_LAST_NAME);
        email=request.getParameter(Parameters.USER_EMAIL);
        password=request.getParameter(Parameters.USER_PASSWORD);
        role=request.getParameter(Parameters.USER_ROLE_ID);
        state=request.getParameter(Parameters.USER_STATE_ID);
        try {
            if(!UserDAO.INSTANCE.isNewUser(email))    {
                update(email);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
            }else {
                page=ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return page;
    }

    private void update(String email) {
        User user;
        try {
            user = UserDAO.INSTANCE.getUserByEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setIdRole(Long.valueOf(role));
            user.setIdState(Long.valueOf(state));
            UserDAO.INSTANCE.updateEntity(user);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
