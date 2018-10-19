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

@WebServlet(urlPatterns = "/form-add")
public class FormAddProduktServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Dodaj produkt</h2>" +
                "<form action='' method='POST'>" +
                "Id: <input type='numer' name='id' /> <br />" +
                "Nazwa: <input type='text' name='name' /> <br />" +
                "Używany: <input type='checkbox' name='used'><br />" +
                "Cena: <input type='number' name='price' step='any'><br />" +
                "Data wydania: <input type='date' name='releaseDate'><br />" +
                "<input type='submit' value=' Dodaj ' />" +
                "</form>" +
                "</body></html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String myCheckBoxValue = request.getParameter("used");

        boolean used;
        if (myCheckBoxValue == null) {
            used = false;
        }
        else {
            used = true;
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

            Map gProducts = (Map) getServletContext().getAttribute("application_products");
            gProducts.put(request.getParameter("id"), laptop);


            out.println("<html><body><h2>Dodano produkt</h2>" +
                    "<p>Id: " + request.getParameter("id") + "<br />" +
                    "<p>Nazwa: " + request.getParameter("name") + "<br />" +
                    "<p>Używany: " + String.valueOf(used) + "<br />" +
                    "<p>Cena: " + request.getParameter("price") + "<br />" +
                    "<p>Data wydania: " + request.getParameter("releaseDate") + "<br />" +
                    "<a href='./'>Powrót</a>" +
                    "</body></html>");
            out.close();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
