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

@WebServlet("/buy")
public class BuyServlet extends HttpServlet {
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
        Map<Long, Laptop> gProducts = (Map<Long, Laptop>) getServletContext().getAttribute("application_products");
        PrintWriter out = response.getWriter();
        out.println("<html><body>" +
                "<h2>Produkty:</h2>" +
                "<table style='border-collapse: collapse;'>");
        Iterator it = gProducts.values().iterator();
        Laptop l;
        while (it.hasNext()) {
            l = (Laptop) it.next();
            out.println("<tr style='border: 1px solid black'>" +
                    "<td>" + l.showDetails() + "</td>");
            if(sCart.containsKey(l.getId())) {
                out.println("<td></td>");
            }
            else {
                out.println("<td><form method='POST' action=''>" +
                        "<input name='id' hidden value='" + l.getId() + "'/>" +
                        "<input type='submit' value='Do koszyka'/>" +
                        "</form></td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("<a href='./summary'>Podsumowanie</a><br>");
        out.println("<a href='./'>Powrót</a>");
        out.println("</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        Map<Long, Laptop> sCart;
        if(session.getAttribute("session_cart") == null) {
            sCart = new HashMap<Long, Laptop>();
        }
        else {
            sCart = (Map<Long, Laptop>) session.getAttribute("session_cart");
        }
        Map<Long, Laptop> gProducts = (Map<Long, Laptop>) getServletContext().getAttribute("application_products");
        Laptop newL = (Laptop) gProducts.get(Long.valueOf(request.getParameter("id")));
        sCart.put(Long.valueOf(request.getParameter("id")), newL);
        session.setAttribute("session_cart", sCart);
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Dodano do koszyka</h2>");
        out.println("<a href='./summary'>Podsumowanie</a><br>");
        out.println("<a href='./buy'>Powrót do zakupów</a>");
        out.println("</body></html>");
    }
}
