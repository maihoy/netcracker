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
public class UpdateDishCommand extends WaiterCommand {

    private Logger logger = Logger.getRootLogger();

    private static String name;
    private static String price;
    private static String id;


    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        id=request.getParameter(Parameters.DISH_ID);
        name=request.getParameter(Parameters.DISH_NAME);
        price=request.getParameter(Parameters.DISH_PRICE);
        try {
            if(!MenuDAO.INSTANCE.isNewDish(name))    {
                update(id);
                page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.WAITER_PAGE_PATH);
            }else{
                logger.warn("Something goes wrong at UpdateDishCommand");
            }
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(),e.getCause());
        }catch (NumberFormatException | NullPointerException e){
            request.setAttribute(Parameters.OPERATION_MESSAGE, MessageManager.INSTANCE.getMessage(MessageConstants.INVALID_NUMBER_FORMAT,locale));
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DISH_UPDATE_PAGE_PATH);
        }
        return page;
    }

    private void update(String id) throws SQLException{
        Dish dish;
            dish = MenuDAO.INSTANCE.getDishById(id);
            dish.setName(name);
            dish.setPrice(Double.valueOf(price));
            dish.setMenuId(Long.valueOf(1));
            MenuDAO.INSTANCE.updateEntity(dish);
    }
}
