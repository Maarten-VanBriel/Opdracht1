package ui.controller;

import domain.db.PersonService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Servlet extends HttpServlet {
    private HandlerFactory handlerFactory = new HandlerFactory();
    private PersonService service = new PersonService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String destination = "index.jsp";
        if (command != null) {
            RequestHandler handler = handlerFactory.getHandler(command, service);
            destination = handler.handleRequest(request, response);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}
