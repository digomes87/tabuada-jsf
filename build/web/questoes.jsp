<%-- 
    Document   : questoes
    Created on : Mar 29, 2024, 12:53:13 PM
    Author     : Diego
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Questões</title>
</head>
<body>
    <h1>Questões</h1>
    <form action="verificar-resposta" method="POST">
        <c:forEach var="resposta" items="${respostas}" varStatus="loop">
            <p>Questão ${loop.index + 1}: Qual é o resultado de ${resposta.num1} x ${resposta.num2}?</p>
            <input type="text" name="resposta${loop.index + 1}">
            <input type="hidden" name="resultado${loop.index + 1}" value="${resposta.resultado}">
            <br>
        </c:forEach>
        <input type="submit" value="Enviar Respostas">
    </form>
</body>
</html>
