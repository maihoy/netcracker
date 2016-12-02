package com.makarevich.command.user;

import com.makarevich.command.UserCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by j on 2.12.16.
 */
public class ReturnUserPage extends UserCommand {
    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        return ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.USER_PAGE_PATH);
    }
}
