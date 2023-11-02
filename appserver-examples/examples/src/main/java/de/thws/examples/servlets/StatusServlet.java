package de.thws.examples.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/status")
public class StatusServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int statusCode = 201;

        String query = req.getQueryString();
        if (query != null && query.contains("throw-error")) {
            int error = 42/0;
            System.out.println(error);
        }

        resp.setStatus(statusCode);
        resp.getWriter().println("Status Code: " + statusCode );
    }

}
