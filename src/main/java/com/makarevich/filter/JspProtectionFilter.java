package com.makarevich.filter;

import com.makarevich.managers.PathManager;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JspProtectionFilter implements Filter {

    private PathManager pathManager = PathManager.INSTANCE;
    private Logger logger = Logger.getRootLogger();

    public void init(FilterConfig fConfig) throws ServletException {
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setStatus(404);
        logger.error("Someone tried to access jsp file directly");
        httpRequest.getRequestDispatcher(pathManager.getString("path.error404")).forward(request, response);

    }
    public void destroy() {
    }
}
