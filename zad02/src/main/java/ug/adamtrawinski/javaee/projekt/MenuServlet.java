package ug.adamtrawinski.javaee.projekt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>" +
                "<h2>Menu</h2>" +
                "<ul>" +
                "<li><a href='about'>Bill Gates</a></li>" +
                "<li><a href='date'>Obecna data</a></li>" +
                "</ul>" +
                "</body></html>");
        out.close();
    }
}
