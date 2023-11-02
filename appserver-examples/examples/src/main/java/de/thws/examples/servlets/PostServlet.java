package de.thws.examples.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("post")
public class PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action(req, resp);
    }

    void action(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("parameter map: " + req.getParameterMap());
        req.getParameterMap().forEach((k, v) -> System.out.println(k + ": " + v[0]));

        resp.getWriter().println("Thank you for your data!");
    }

}
