package de.thws.examples.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("tss")
public class ThreadSafeServlet extends HttpServlet {

    String query;

    @Override
    public void init() throws ServletException {
        System.out.println("Init ThreadSafeServlet " + this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet ThreadSafeServlet " + this);

        // FIXME this code is NOT thread safe
        query = req.getQueryString();

        System.out.println("query: " + query);
        resp.getWriter().println("query: " + query);
    }

    @Override
    public void destroy() {
        System.out.println("destroy ThreadSafeServlet " + this);
    }

}
