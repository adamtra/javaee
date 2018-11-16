<%@ page import="ug.adamtrawinski.javaee.sklep.domain.Survey" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ankiety</title>
</head>
<body>
<jsp:useBean id="surveyStorage" class="ug.adamtrawinski.javaee.sklep.service.SurveyService" scope="application" />

<%
    for(Survey survey: surveyStorage.getAllSurveys().values()) {
        out.println(survey);
        out.print("<br>");
    }
%>
</body>
</html>
