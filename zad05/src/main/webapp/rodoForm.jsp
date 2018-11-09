<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zgoda RODO</title>
</head>
<body>
    <form method="POST" action="rodoSuccess.jsp">
        <p>
            Wyrażam zgodę na przetwarzanie danych osobowych zgodnie z np. wysłaniem zapytania przez formularz kontaktowy.
            <input type='checkbox' name='processingData' required>
        </p>
        <p>
            Wyrażam zgodę na przekazywanie moich danych osobowych osobom trzecim.
            <input type='checkbox' name='sellingData' required>
        </p>
        <p>
            Wyrażam zgodę na wysyłanie maili marketingowych.
            <input type='checkbox' name='sendingNewsletter'>
        </p>
        <input type='submit' value='Wyślij'/>
    </form>
    <a href="rodoFailure.jsp">Nie wyrażam zgody</a>
</body>
</html>
