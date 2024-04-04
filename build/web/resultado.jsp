<%-- 
    Document   : resultado.jsp
    Created on : Apr 3, 2024, 7:49:50 AM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultado</title>
</head>
<body>
    <h1>Resultado!</h1>
    <p>Matrícula: <%= request.getParameter("matricula") %></p>
    <p>Nome: <%= request.getParameter("nome") %></p>
    <p>Nota Obtida: <%= request.getAttribute("nota") %></p>
</body>
</html>
