<%@ page import="java.util.Iterator" %>
<%@ page import="ug.adamtrawinski.javaee.sklep.domain.Laptop" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Podsumowanie</title>
</head>
<body>
    <jsp:useBean id="cart" class="ug.adamtrawinski.javaee.sklep.service.StorageService" scope="session" />
    <h2>Koszyk:</h2>
    <table style='border-collapse: collapse;'>
        <%
            double total = 0;
            Map<Long, Laptop> laptops = cart.getAllLaptops();
            if(laptops.size() > 0) {
                Iterator it = laptops.values().iterator();
                Laptop l;
                while (it.hasNext()) {
                    l = (Laptop) it.next();
                    total += l.getPrice();
                    out.println("<tr style='border: 1px solid black'>" +
                            "<td>" + l.showDetails() + "</td>");
                    out.println("<td>");
                    out.println("</tr>");
                }
            } else {
                out.println("<h2>Koszyk jest pusty</h2>");
            }
        %>
    </table>
    <%
        if(laptops.size() > 0) {
            out.println("<p>Łączna kwota: "+ total + "</p><br>");
        }
    %>
    <a href='index.jsp'>Powrót</a>

</body>
</html>
