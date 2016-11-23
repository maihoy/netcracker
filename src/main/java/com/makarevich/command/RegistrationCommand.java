package com.makarevich.command;

import com.makarevich.beans.User;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.MessageConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.UserDAO;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.MessageManager;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by j on 18.11.16.
 */
public class RegistrationCommand implements ActionCommand {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String password;
    private static String role;
    private static String state;
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        firstName=request.getParameter(Parameters.USER_FIRST_NAME);
        lastName=request.getParameter(Parameters.USER_LAST_NAME);
        email=request.getParameter(Parameters.USER_EMAIL);
        password=request.getParameter(Parameters.USER_PASSWORD);
        role=request.getParameter(Parameters.USER_ROLE_ID);
        state=request.getParameter(Parameters.USER_STATE_ID);
        try{
            if(areFieldsFullStocked()){
              //  int userId = Integer.valueOf(userIdString)  ;
                    if(UserDAO.INSTANCE.isNewUser(email))    {
                        registrate();
                        page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
                       // request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.SUCCESS_OPERATION));
                    }else {
                        page=ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
                        request.setAttribute(Parameters.ERROR_USER_EXSISTS,MessageManager.INSTANCE.getProperty(MessageConstants.USER_EXSISTS));
                    }
            }else {
                request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.EMPTY_FIELDS));
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
            }
        }catch (SQLException e) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getProperty(MessageConstants.ERROR_DATABASE));
        }
        catch (NumberFormatException e) {
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getProperty(MessageConstants.INVALID_NUMBER_FORMAT));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
        }
        catch(NullPointerException e){
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
        }
        return page;

    }

    private void registrate() throws SQLException{
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setIdRole(Long.valueOf(role));
        user.setIdState(Long.valueOf(state));
       // user.addRole(Roles.valueOf(roles));
        UserDAO.INSTANCE.createEntity(user);
    }

    private boolean areFieldsFullStocked(){
        boolean isFullStocked = false;
        if(!firstName.isEmpty() & !lastName.isEmpty() & !email.isEmpty() & !password.isEmpty()){
            isFullStocked = true;
        }
        return isFullStocked;
    }
}