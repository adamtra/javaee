<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Przesłano ankietę</title>
  </head>
  <body>
  <jsp:useBean id="survey" class="ug.adamtrawinski.javaee.sklep.domain.Survey" scope="session" />

  <jsp:useBean id="surveyStorage" class="ug.adamtrawinski.javaee.sklep.service.SurveyService" scope="application" />

  <jsp:setProperty name="survey" property="frequency" param="frequency" />

  <%
//    List<String> selectedComments = new ArrayList<>();
//    for (String comment : request.getParameterValues("comments")) {
//      selectedComments.add(comment);
//    }
//    survey.setComments(selectedComments);

    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    Date dateFrom = format.parse(request.getParameter("usedFrom"));
    Date dateTo = format.parse(request.getParameter("usedTo"));
    survey.setUsedFrom(dateFrom);
    survey.setUsedTo(dateTo);
    surveyStorage.add(session.getId(), survey);
  %>
  <h2>Przesłano ankietę</h2>

  <p>Data użytkowanie (od):
      <%
      out.println(request.getParameter("usedFrom"));
    %>
  </p>

  <p>Data użytkowanie (do):
    <%
      out.println(request.getParameter("usedTo"));
    %>
  </p>

  <p>Częstotliwość: ${survey.frequency}</p>

  <%--<p>Uwagi: ${survey.comments}</p>--%>
  </body>
</html>