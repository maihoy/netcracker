package com.makarevich.command.waiter;

import com.makarevich.command.WaiterCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by j on 30.11.16.
 */
public class GoToAddDishCommand extends WaiterCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.DISH_ADD_PAGE_PATH);
    }
}
