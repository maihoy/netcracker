package com.makarevich.command.waiter;

import com.makarevich.beans.Dish;
import com.makarevich.command.WaiterCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.MenuDAO;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Locale;

/**
 * Created by j on 25.11.16.
 */
public class GoToEditMenuCommand extends WaiterCommand {
    private Logger logger = Logger.getRootLogger();
    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        String dishId=request.getParameter(Parameters.DISH_ID);
        HttpSession session= request.getSession();
        String page =null;
        try {
            Dish dishToEdit= MenuDAO.INSTANCE.getDishById(dishId);
            session.setAttribute(Parameters.DISH_TO_EDIT, dishToEdit);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DISH_UPDATE_PAGE_PATH);

        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(),e.getCause());
        }
        return page;
    }
}
