package com.makarevich.command.admin;

import com.makarevich.command.AdminCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by j on 2.12.16.
 */
public class ReturnAdminPage extends AdminCommand {
    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        return ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.ADMIN_PAGE_PATH);
    }
}
