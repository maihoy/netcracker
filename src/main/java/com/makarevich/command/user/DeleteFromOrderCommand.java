package com.makarevich.command.user;

import com.makarevich.command.UserCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.OrderDAO;
import com.makarevich.managers.ConfigurationManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * Created by j on 30.11.16.
 */
public class DeleteFromOrderCommand extends UserCommand {
    private Logger logger = Logger.getRootLogger();
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        String orderId=request.getParameter(Parameters.ORDER_ID);
        try {
            OrderDAO.INSTANCE.deleteByOrderId(orderId);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SHOW_ORDER_PATH);

        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(),e.getCause());
        }
        return page;
    }
}
