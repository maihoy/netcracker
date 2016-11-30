package com.makarevich.command.waiter;

import com.makarevich.beans.Dish;
import com.makarevich.command.WaiterCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.MessageConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.MenuDAO;
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
public class AddToMenuCommand extends WaiterCommand {
    private static String name;
    private static String price;
    private Logger logger = Logger.getRootLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String page;
        name=request.getParameter(Parameters.DISH_NAME);
        price=request.getParameter(Parameters.DISH_PRICE);

        Locale locale = LocaleManager.INSTANCE.resolveLocale(request);
        try{
                if(MenuDAO.INSTANCE.isNewDish(name))    {
                    addDish();
                    page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.WAITER_PAGE_PATH);
                   logger.info("Dish "+name+" is added");
                }else {
                    page=ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DISH_ADD_PAGE_PATH);
                    request.setAttribute(Parameters.ERROR_DISH_EXISTS, MessageManager.INSTANCE.getMessage(MessageConstants.DISH_EXISTS,locale));
                    logger.warn("The same dish is already exists");
               }
        }catch (SQLException e) {
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ERROR_PAGE_PATH);
            request.setAttribute(Parameters.ERROR_DATABASE, MessageManager.INSTANCE.getMessage(MessageConstants.ERROR_DATABASE,locale));
        }
        catch (NumberFormatException | NullPointerException e) {
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getMessage(MessageConstants.INVALID_NUMBER_FORMAT,locale));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DISH_ADD_PAGE_PATH);
        }
        return page;


    }

    private void addDish() throws SQLException {
        Dish dish=new Dish();
        dish.setName(name);
        dish.setPrice(Double.valueOf(price));
        dish.setMenuId(Long.valueOf(1));
        MenuDAO.INSTANCE.createEntity(dish);
    }
}
