package ug.adamtrawinski.javaee.sklep.web;

import ug.adamtrawinski.javaee.sklep.domain.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class MenuServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>" +
                "<h2>Witaj w sklepie</h2>" +
                "<ul>" +
                "<li><a href='form-add'>Dodaj produkt</a></li>" +
                "<li><a href='buy'>Produkty</a></li>" +
                "</ul>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    public void init() throws ServletException {

        Map<Long, Laptop> products = new HashMap<Long, Laptop>();
        getServletContext().setAttribute("application_products", products);

    }
}
