package com.makarevich.command;

import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by j on 18.11.16.
 */
public class GoToRegistrationCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.REGISTRATION_PAGE_PATH);
    }
}
