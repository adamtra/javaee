<%@ page import="ug.adamtrawinski.javaee.sklep.domain.Laptop" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodano do koszyka</title>
</head>
<body>

    <jsp:useBean id="storage" class="ug.adamtrawinski.javaee.sklep.service.StorageService" scope="application" />
    <jsp:useBean id="cart" class="ug.adamtrawinski.javaee.sklep.service.StorageService" scope="session" />

    <%
        Map<Long, Laptop> laptops = storage.getAllLaptops();
        Laptop laptop = laptops.get(Long.valueOf(request.getParameter("id")));
        cart.add(laptop);
    %>

    <h2>Dodano do koszyka</h2>
    <p>
        <a href="summary.jsp">Podsumowanie</a><br>
        <a href="buyLaptop.jsp">Powrót do zakupów</a>
    </p>

</body>
</html>
