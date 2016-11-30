package com.makarevich.command;

import com.makarevich.beans.User;
import com.makarevich.dao.UserDAO;
import com.makarevich.filter.UserType;

import java.sql.SQLException;

/**
 * Created by j on 29.11.16.
 */
public abstract class AdminCommand extends ActionCommand {
    @Override
    public boolean checkAccess(User user) {
        if (user != null){
            try {
                UserType userType=UserDAO.INSTANCE.getUserRole(user.getEmail());
                if (user != null && UserType.ADMIN.equals(userType) && user.getIdState()==1){
                    return true;
                }
            }catch (SQLException e) {
                System.out.println(e);
            }
        }
        return false;
    }
}
