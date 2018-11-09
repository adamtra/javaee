<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zgoda udzielona</title>
</head>
<body>
    <jsp:useBean id="rodo" class="ug.adamtrawinski.javaee.sklep.service.RodoService" scope="session" />

    <%
        if (request.getParameter("processingData") == null) {
            rodo.setProcessingData(false);
        }
        else {
            rodo.setProcessingData(true);
        }

        if (request.getParameter("sellingData") == null) {
            rodo.setSellingData(false);
        }
        else {
            rodo.setSellingData(true);
        }

        if (request.getParameter("sendingNewsletter") == null) {
            rodo.setSendingNewsletter(false);
        }
        else {
            rodo.setSendingNewsletter(true);
        }
    %>
    <h2>Dziękujemy za udzielenie zgody.</h2>
    <h2>Możesz teraz korzystać z naszej strony.</h2>
    <a href="./">Strona główna</a>
</body>
</html>
