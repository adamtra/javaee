<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodaj produkt</title>
    </head>
    <body>
    <jsp:useBean id="storage" class="ug.adamtrawinski.javaee.sklep.service.StorageService" scope="application" />
    <jsp:useBean id="laptop" class="ug.adamtrawinski.javaee.sklep.domain.Laptop" scope="session" />

        <h2>Dodaj produkt</h2>
        <form action='addLaptop.jsp' method='POST'>
            Id: <input type='number' name='id' required value="${laptop.id}" /><br>
            Nazwa: <input type='text' name='name' required value="${laptop.name}" /> <br>
            Używany: <input type='checkbox' name='used'
            <%
                if(laptop.isUsed()) {
                    out.println("checked");
                }
            %>/><br>
            Cena: <input type='number' name='price' step='any' required value="${laptop.price}" /><br>
            Data wydania: <input type='date' name='releaseDate' required
            <%
                SimpleDateFormat df = new SimpleDateFormat ("yyyy-MM-dd");
                out.println("value = '" + df.format(laptop.getReleaseDate()) + "'");
            %> /><br>
            <input type='submit' value='Dodaj'/>
        </form>
        <a href='index.jsp'>Powrót</a>
    </body>
</html>
