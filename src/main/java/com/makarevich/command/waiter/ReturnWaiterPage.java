package com.makarevich.command.waiter;

import com.makarevich.command.WaiterCommand;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;
import com.makarevich.managers.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by j on 2.12.16.
 */
public class ReturnWaiterPage extends WaiterCommand {
    @Override
    public String execute(HttpServletRequest request) {
        Locale locale= LocaleManager.INSTANCE.resolveLocale(request);
        return ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.WAITER_PAGE_PATH);
    }
}
