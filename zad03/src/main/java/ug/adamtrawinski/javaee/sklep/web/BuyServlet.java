package ug.adamtrawinski.javaee.sklep.web;

import ug.adamtrawinski.javaee.sklep.domain.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        Map gProducts = (Map) getServletContext().getAttribute("application_products");

        PrintWriter out = response.getWriter();
        out.println("<html><body>" +
                "<h2>Produkty:</h2>" +
                "<ul>");
        Iterator it = gProducts.values().iterator();
        Laptop l;
        while (it.hasNext()) {
            l = (Laptop) it.next();
            out.println("<li>" + l.showDetails() + "</li>");
        }
        out.println("</ul><a href='./'>Powrót</a>");

        out.println("</body></html>");
        out.close();
    }
}
