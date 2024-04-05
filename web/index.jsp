<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Prova de Tabuada Online</title>
</head>
<body>
    <h1>Prova de Tabuada Online</h1>
    <form action="questoes" method="post">
        <label for="matricula">Matrícula:</label>
        <input type="text" id="matricula" name="matricula" required>
        <br>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>
        <br>
        <br>
        <button type="submit">Iniciar prova</button>
    </form>
</body>
</html>
