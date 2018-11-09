<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sklep</title>
    </head>
    <body>
    <jsp:useBean id="rodo" class="ug.adamtrawinski.javaee.sklep.service.RodoService" scope="session" />
    <%
        if(!rodo.isProcessingData() || !rodo.isSellingData()) {
            out.println("<script>window.location = 'rodoForm.jsp';</script>");
        }
    %>

        <h2>Witaj w sklepie</h2>
        <ul>
            <li>
                <a href='getLaptopData.jsp'>Dodaj produkt</a>
            </li>
            <li>
                <a href='buyLaptop.jsp'>Kup produkty</a>
            </li>
            <li>
                <a href='summary.jsp'>Podsumowanie</a>
            </li>
        </ul>
    </body>
</html>
