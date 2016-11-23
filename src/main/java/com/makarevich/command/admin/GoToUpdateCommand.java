package com.makarevich.command.admin;

import com.makarevich.command.ActionCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by j on 22.11.16.
 */
public class GoToUpdateCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.UPDATE_PAGE_PATH);
    }
}
