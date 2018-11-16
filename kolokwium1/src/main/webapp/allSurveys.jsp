<%@ page import="ug.adamtrawinski.javaee.sklep.domain.Survey" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ankiety</title>
</head>
<body>
<jsp:useBean id="surveyStorage" class="ug.adamtrawinski.javaee.sklep.service.SurveyService" scope="application" />

    <form method="post" action="deleteSurvey.jsp">
    <%
        for(String key: surveyStorage.getAllSurveys().keySet()) {
            Survey survey = surveyStorage.getAllSurveys().get(key);
            out.print("<input type='checkbox' name='key' value='"+ key + "'><br>");
            out.println(survey);
            out.print("<hr>");
        }
    %>
        <button type="submit">Usuń zaznaczone</button>
    </form>
<p>
    <a href="index.jsp">Wróć do menu</a>
</p>
</body>
</html>
