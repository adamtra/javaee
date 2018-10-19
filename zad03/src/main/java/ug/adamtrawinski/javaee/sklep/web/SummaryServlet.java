package ug.adamtrawinski.javaee.sklep.web;

import ug.adamtrawinski.javaee.sklep.domain.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/summary")
public class SummaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        Map<Long, Laptop> sCart;
        if(session.getAttribute("session_cart") == null) {
            sCart = new HashMap<Long, Laptop>();
        }
        else {
            sCart = (Map<Long, Laptop>) session.getAttribute("session_cart");
        }
        double total = 0;
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if(sCart.size() > 0) {
            out.println("<h2>Koszyk:</h2>" +
                    "<table style='border-collapse: collapse;'>");
            Iterator it = sCart.values().iterator();
            Laptop l;
            while (it.hasNext()) {
                l = (Laptop) it.next();
                total += l.getPrice();
                out.println("<tr style='border: 1px solid black'>" +
                        "<td>" + l.showDetails() + "</td></tr>");
            }
            out.println("</table>");
            out.println("<p>Łączna kwota: " + total + "</p>");
        }
        else {
            out.println("<h2>Koszyk jest pusty</h2>");
        }
        out.println("<a href='./'>Powrót</a>");
        out.println("</body></html>");
        out.close();
    }
}
