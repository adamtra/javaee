<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usunięto</title>
</head>
<body>
<jsp:useBean id="surveyStorage" class="ug.adamtrawinski.javaee.sklep.service.SurveyService" scope="application" />

    <h2>Usunięto ankiety</h2>
    <%
        for (String key : request.getParameterValues("key")) {
            surveyStorage.delete(key);
        }
    %>
<p>
    <a href="index.jsp">Wróć do menu</a>
</p>
</body>
</html>
