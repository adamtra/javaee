package ug.adamtrawinski.javaee.sklep.web;

import ug.adamtrawinski.javaee.sklep.domain.Laptop;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(urlPatterns = "/add-product")
public class AddProduktServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Dodaj produkt</h2>" +
                "<form action='' method='POST'>" +
                "Id: <input type='numer' name='id' required /> <br />" +
                "Nazwa: <input type='text' name='name' required /> <br />" +
                "Używany: <input type='checkbox' name='used' /><br />" +
                "Cena: <input type='number' name='price' step='any' required /><br />" +
                "Data wydania: <input type='date' name='releaseDate' required /><br />" +
                "<input type='submit' value='Dodaj' />" +
                "</form>" +
                "<a href='./'>Powrót</a>" +
                "</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String myCheckBoxValue = request.getParameter("used");

        boolean used;
        String state;
        if (myCheckBoxValue == null) {
            used = false;
            state = "Nie";
        }
        else {
            used = true;
            state = "Tak";
        }

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = format.parse(request.getParameter("releaseDate"));

            Laptop laptop = new Laptop();
            laptop.setId(Long.valueOf(request.getParameter("id")));
            laptop.setName(request.getParameter("name"));
            laptop.setUsed(used);
            laptop.setPrice(Double.valueOf(request.getParameter("price")));
            laptop.setReleaseDate(date);

            Map<Long, Laptop> gProducts = (Map<Long, Laptop>) getServletContext().getAttribute("application_products");
            if(gProducts.containsKey(Long.valueOf(request.getParameter("id")))) {
                out.println("<html><body><h2>Nie udało się dodać produktu - takie Id już istnieje</h2>" +
                        "<a href='./'>Powrót</a>" +
                        "</body></html>");
                out.close();
            }
            else {
                gProducts.put(Long.valueOf(request.getParameter("id")), laptop);
                out.println("<html><body><h2>Dodano produkt</h2>" +
                        "<p>Id: " + request.getParameter("id") + "<br />" +
                        "<p>Nazwa: " + request.getParameter("name") + "<br />" +
                        "<p>Używany: " + state + "<br />" +
                        "<p>Cena: " + request.getParameter("price") + "<br />" +
                        "<p>Data wydania: " + request.getParameter("releaseDate") + "<br />" +
                        "<a href='./'>Powrót</a>" +
                        "</body></html>");
                out.close();
            }
        } catch (ParseException e) {
            out.println("<html><body><h2>Nie udało się dodać produktu - format daty jest nie poprawny</h2>" +
                    "<a href='./'>Powrót</a>" +
                    "</body></html>");
            out.close();
        }

    }
}
