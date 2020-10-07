package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Add extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = new Person();

        List<String> errors = new ArrayList<String>();
        getFirstname(person, request, errors);
        getLastname(person, request, errors);
        getEmail(person, request, errors);
        getPassword(person, request, errors);
        getUserid(person, request, errors);

        String destination;
        try {
            service.add(person);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }

        if (errors.size() > 0) {
            request.setAttribute("errors", errors);
            destination = "register.jsp";
        }
        else {
            destination = "Controller?command=Overview";
        }

        return destination;

    }

    private void getEmail(Person person, HttpServletRequest request, List<String> errors) {
        String email = request.getParameter("email");
        request.setAttribute("emailEerst", email);
        try {
            person.setEmail(email);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void getLastname(Person person, HttpServletRequest request, List<String> errors) {
        String lastname = request.getParameter("lastName");
        request.setAttribute("lastnameEerst", lastname);
        try {
            person.setLastName(lastname);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void getFirstname(Person person, HttpServletRequest request, List<String> errors) {
        String firstname = request.getParameter("firstName");
        request.setAttribute("firstnameEerst", firstname);
        try {
            person.setFirstName(firstname);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void getPassword(Person person, HttpServletRequest request, List<String> errors) {
        String password = request.getParameter("password");
        request.setAttribute("passwordEerst", password);
        try {
            person.setPassword(password);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }

    private void getUserid(Person person, HttpServletRequest request, List<String> errors) {
        String userid = request.getParameter("userid").toLowerCase();
        request.setAttribute("useridEerst", userid);
        try {
            person.setUserid(userid);
        }
        catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}
