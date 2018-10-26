<%@ page import="java.util.Iterator" %>
<%@ page import="ug.adamtrawinski.javaee.sklep.domain.Laptop" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kup produkt</title>
    </head>
    <body>
        <jsp:useBean id="storage" class="ug.adamtrawinski.javaee.sklep.service.StorageService" scope="application" />
        <h2>Produkty:</h2>
        <table style='border-collapse: collapse;'>
            <%
                Iterator it = storage.getAllLaptops().values().iterator();
                Laptop l;
                while (it.hasNext()) {
                    l = (Laptop) it.next();
                    out.println("<tr style='border: 1px solid black'>" +
                            "<td>" + l.showDetails() + "</td>");
                    out.println("</tr>");
                }
            %>
        </table>
        <a href='summary.jsp'>Podsumowanie</a><br>
        <a href='index.jsp'>Powrót</a>
    </body>
</html>
