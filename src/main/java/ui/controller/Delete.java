package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Delete extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String destination;
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("person");
        List<String> errors = new ArrayList<>();
        try {
            service.delete(person.getUserid());
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
        if (errors.isEmpty()) {
            request.getSession().invalidate();
            destination = "index.jsp";
        } else {
            destination = "delete.jsp";
        }

        return destination;
    }
}
