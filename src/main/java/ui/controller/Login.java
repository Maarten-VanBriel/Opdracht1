package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Login extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<String> errors = new ArrayList<>();
        String userid = request.getParameter("userid").toLowerCase();
        String password = request.getParameter("password");
        Person person = new Person();
        try {
            person = service.get(userid);
            person.isCorrectPassword(password);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
        try {
            if (errors.isEmpty() && person.isCorrectPassword(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("person", person);
            }
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
        }
        return "index.jsp";
    }
}
