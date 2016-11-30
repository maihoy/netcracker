package com.makarevich.command.user;

import com.makarevich.beans.Order;
import com.makarevich.beans.User;
import com.makarevich.command.UserCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.MessageConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.OrderDAO;
import com.makarevich.dao.UserDAO;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;
import com.makarevich.managers.MessageManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by j on 30.11.16.
 */
public class AddToOrder extends UserCommand {
    private static String userEmail;
    private static String dishId;

    private Logger logger = Logger.getRootLogger();
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        //userEmail=request.getParameter(Parameters.USER_EMAIL);
        User user = (User) request.getSession().getAttribute(Parameters.USER);
        userEmail=user.getEmail();
        dishId=request.getParameter(Parameters.DISH_ID);
        Locale locale = LocaleManager.INSTANCE.resolveLocale(request);
        try {
            addDishToOrder(dishId, userEmail);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SHOW_ORDER_PATH);
            logger.info("Dish "+dishId+" is added to order");
        } catch (SQLException e) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getMessage(MessageConstants.ERROR_DATABASE,locale));

        }

        return page;
    }

    private void addDishToOrder(String name, String userEmail) throws SQLException{
        User user= UserDAO.INSTANCE.getUserByEmail(userEmail);
        Order order=new Order();
        order.setUserEmail(user.getEmail());
        order.setState(Long.valueOf(1));
        order.setDishName(name);
        OrderDAO.INSTANCE.createEntity(order);
    }
}
