package de.thws.examples.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/example1")
public class Example1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lang = req.getHeader("Accept-Language");
        System.out.println("lang: " + lang);

        String query = req.getQueryString();
        System.out.println("query: " + query);

        resp.getWriter().println("Hallo THWS! I'm a servlet\n lang:" + lang);
    }

}
