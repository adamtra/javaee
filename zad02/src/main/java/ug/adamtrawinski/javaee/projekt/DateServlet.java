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

@WebServlet("/date")
public class DateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        Date date = new Date( );
        SimpleDateFormat df = new SimpleDateFormat ("dd-MM-yyyy");

        out.println("<html><body>" +
                "<p>Obecna data: " + df.format(date) + "</p>" +
                "<a href='./'>Powrót</a>" +
                "</body></html>");
        out.close();
    }
}
