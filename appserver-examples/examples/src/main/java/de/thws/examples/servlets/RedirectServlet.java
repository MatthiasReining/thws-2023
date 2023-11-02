package de.thws.examples.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String query = req.getQueryString();
        String location = "https://google.com";

        if (query != null) {
            location = query.split("=")[1];
        }

        System.out.println("redirect to " + location);
        resp.sendRedirect(location);
    }

}
