package com.makarevich.filter;

import com.makarevich.beans.User;
import com.makarevich.command.ActionCommand;
import com.makarevich.command.factory.ActionFactory;
import com.makarevich.constants.Parameters;
import com.makarevich.managers.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * command access filter
 */
public class CommandAccessFilter implements Filter {

    private PathManager pathManager = PathManager.INSTANCE;
    private Logger logger = Logger.getRootLogger();

    public void destroy() {
        //blank
    }

    /**
     * Checks the user role before executing command
     * If user doesn't have required role a 403 error
     * page will be displayed
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        ActionFactory actionFactory = ActionFactory.INSTANCE;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        ActionCommand command = actionFactory.defineCommand(request);
        User user = (User) request.getSession().getAttribute(Parameters.USER);

        if (command.checkAccess(user)){
            chain.doFilter(req, resp);
        } else{
            response.setStatus(403);
            logger.error(String.format("Access denied for %s to the following command: %s", (user != null) ? user : "anonymous user", command));
            request.getRequestDispatcher(pathManager.getString("path.error403")).forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        // blank
    }

}
