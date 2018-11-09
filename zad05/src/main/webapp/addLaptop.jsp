<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dodano produkt</title>
  </head>
  <body>
  <jsp:useBean id="laptop" class="ug.adamtrawinski.javaee.sklep.domain.Laptop" scope="session" />

  <jsp:setProperty name="laptop" property="id" param="id" />
  <jsp:setProperty name="laptop" property="name" param="name" />
  <jsp:setProperty name="laptop" property="price" param="price" />


  <jsp:useBean id="storage" class="ug.adamtrawinski.javaee.sklep.service.StorageService" scope="application" />

  <%
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
    Date date = format.parse(request.getParameter("releaseDate"));
    laptop.setReleaseDate(date);
    laptop.setUsed(used);
    storage.add(laptop);

  %>

    <h2>Dodano produkt:</h2>
    <p>Id: ${laptop.id} </p>
    <p>Nazwa: ${laptop.name} </p>
    <p>Używany:
      <%
        out.println(state);
      %>
    </p>
    <p>Cena: ${laptop.price} </p>
    <p>Data wydania:
    <%
      out.println(request.getParameter("releaseDate"));
    %>
    </p>
    <p>
      <a href="index.jsp">Wróć do menu</a>
    </p>
  </body>
</html>