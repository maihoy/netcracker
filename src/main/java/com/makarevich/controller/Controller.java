package com.makarevich.controller;

import com.makarevich.command.ActionCommand;
import com.makarevich.command.factory.ActionFactory;
import com.makarevich.constants.ConfigsConstants;
import com.makarevich.managers.ConfigurationManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  private void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String page =null;
    ActionFactory client = ActionFactory.INSTANCE;
    ActionCommand command = client.defineCommand(request);
    System.out.println(command.toString());
    page = command.execute(request);
    if (page != null) {
      RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
      dispatcher.forward(request, response);
    } else {
      page = ConfigurationManager.INSTANCE.getProperty(ConfigsConstants.INDEX_PAGE_PATH);
      response.sendRedirect(request.getContextPath() + page);
    }
  }
}