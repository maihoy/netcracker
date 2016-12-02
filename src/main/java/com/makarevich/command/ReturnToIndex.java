package com.makarevich.command;

import com.makarevich.beans.User;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by j on 2.12.16.
 */
public class ReturnToIndex extends ActionCommand {
    @Override
    public boolean checkAccess(User user) {
        return true;
    }

    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        return ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
    }
}
