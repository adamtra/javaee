<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ankieta</title>
</head>
<body>
    <jsp:useBean id="survey" class="ug.adamtrawinski.javaee.sklep.domain.Survey" scope="session" />

    <h2>Uzupełnij ankietę</h2>
    <form action='sendSurvey.jsp' method='POST'>
        Data użytkowanie (od): <input type='date' name='usedFrom' required value="<%
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                out.print(df.format(survey.getUsedFrom()));
            %>" /><br>
        Data użytkowanie (do): <input type='date' name='usedTo' required value="<%
                out.print(df.format(survey.getUsedTo()));
            %>" /><br>
        <p>Częstotliwość użytkowania:</p>
        <input type="radio" name="frequency" value="Codziennie" <%
            if(survey.getFrequency().equals("Codzinnie")) {
                out.print("checked");
            }
        %>>Codzinnie<br>
        <input type="radio" name="frequency" value="Raz w tygodniu" <%
            if(survey.getFrequency().equals("Raz w tygodniu")) {
                out.print("checked");
            }
        %>>Raz w tygodniu<br>
        <input type="radio" name="frequency" value="Rzadziej"<%
            if(survey.getFrequency().equals("Rzadziej")) {
                out.print("checked");
            }
        %>>Rzadziej<br>
        <p>Uwagi:</p>
        <input type="checkbox" name="comments" <%
            if(survey.ifCommentSelected("Uszkodzony ekran")) {
                out.print("checked");
            }
        %>>Uszkodzony ekran<br>
        <input type="checkbox" name="comments" <%
            if(survey.ifCommentSelected("Nie włącza się")) {
                out.print("checked");
            }
        %>>Nie włącza się<br>
        <input type="checkbox" name="comments" <%
            if(survey.ifCommentSelected("Wolno działa")) {
                out.print("checked");
            }
        %>>Wolno działa<br>
        <input type="checkbox" name="comments" <%
            if(survey.ifCommentSelected("Jest super")) {
                out.print("checked");
            }
        %>>Jest super<br>
    </form>
</body>
</html>
