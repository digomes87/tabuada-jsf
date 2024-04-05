<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Questões de Tabuada</title>
</head>
<body>
    <h1>Questões de Tabuada</h1>
    <form action="resultado" method="post">
        <%
            int numQuestoes = 10; // Número de questões
            for (int i = 1; i <= numQuestoes; i++) {
                int num1 = (int) (Math.random() * 9) + 1;
                int num2 = (int) (Math.random() * 9) + 1;
                out.println("<p>Questão (" + i + "): " + num1 + " * " + num2 + " = </p>");
                out.println("<input type='hidden' name='num1" + i + "' value='" + num1 + "'>");
                out.println("<input type='hidden' name='num2" + i + "' value='" + num2 + "'>");
                out.println("<input type='text' name='resposta" + i + "' required><br>");
            }
        %>
        <br />
        <button type="submit">Finalizar Prova</button>
    </form>
</body>
</html>
