package com.makarevich.command.waiter;

import com.makarevich.command.WaiterCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.MenuDAO;
import com.makarevich.managers.ConfigurationManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by j on 30.11.16.
 */
public class DeleteDishCommand extends WaiterCommand {
    private Logger logger = Logger.getRootLogger();
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        String dishId=request.getParameter(Parameters.DISH_ID);
        try {
            MenuDAO.INSTANCE.deleteById(dishId);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SHOW_ORDER_PATH);

        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(),e.getCause());
        }
        return page;
    }
}
