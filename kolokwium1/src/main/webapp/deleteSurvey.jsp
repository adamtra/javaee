<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Usunięto</title>
</head>
<body>
<jsp:useBean id="surveyStorage" class="ug.adamtrawinski.javaee.sklep.service.SurveyService" scope="application" />

    <%
        for (String key : request.getParameterValues("key")) {
            surveyStorage.delete(key);
        }
    %>

</body>
</html>
