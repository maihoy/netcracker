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
import java.util.List;
import java.util.Locale;

/**
 * Created by j on 29.11.16.
 */
public class ShowMenuCommand extends WaiterCommand {
    private Logger logger = Logger.getRootLogger();
    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        String page=null;
        HttpSession session= request.getSession();
        try {
            List<Dish> dishes= MenuDAO.INSTANCE.findAll();
            session.setAttribute(Parameters.DISH_LIST, dishes);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.WAITER_SHOW_ALL_DISHES_PATH);
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(),e.getCause());
        }
        return page;
    }
}
