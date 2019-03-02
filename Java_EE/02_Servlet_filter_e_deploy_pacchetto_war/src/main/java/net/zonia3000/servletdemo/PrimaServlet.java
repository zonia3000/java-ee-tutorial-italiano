package net.zonia3000.servletdemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sonia Zorba <sonia at zonia3000.net>
 */
@WebServlet(urlPatterns = "/hello")
public class PrimaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("hello2");
        req.getRequestDispatcher("hello2").forward(req, resp);
//        resp.setContentType("text/plain");
//        resp.getWriter().write("queryString=" + req.getQueryString() + "\n");
//        resp.getWriter().write("param username=" + req.getParameter("username"));
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().write("queryString=" + req.getQueryString() + "\n");
        resp.getWriter().write("param username=" + req.getParameter("username"));
    }
    
}
