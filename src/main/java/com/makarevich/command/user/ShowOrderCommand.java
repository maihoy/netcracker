package com.makarevich.command.user;

import com.makarevich.beans.Order;
import com.makarevich.beans.User;
import com.makarevich.command.UserCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.constants.Parameters;
import com.makarevich.dao.OrderDAO;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

/**
 * Created by j on 30.11.16.
 */
public class ShowOrderCommand extends UserCommand {
    private Logger logger = Logger.getRootLogger();

    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        String page=null;
        HttpSession session= request.getSession();
        User user = (User) session.getAttribute(Parameters.USER);
        try {
            List<Order> order= OrderDAO.INSTANCE.findAll(user);
            session.setAttribute(Parameters.ORDER, order);
            page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_SHOW_ORDER_PATH);
        } catch (SQLException e) {
            logger.error(e.getLocalizedMessage(),e.getCause());
        }
        return page;
        }
    }
