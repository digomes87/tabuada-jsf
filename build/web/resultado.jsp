<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="module.ResultadoAluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Resultado</title>
</head>
<body>
    <h1>Ranking dos Resultados</h1>
        <table>
            <thead>
                <tr>
                    <th>Posição</th>
                    <th>Matrícula</th>
                    <th>Nome</th>
                    <th>Pontuação Obtida</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    List<ResultadoAluno> resultados = (List<ResultadoAluno>) request.getAttribute("resultados");
                    Collections.sort(resultados, (r1, r2) -> Integer.compare(r2.getPontuacao(), r1.getPontuacao())); // Ordena os resultados pela pontuação (do maior para o menor)
                    int posicao = 1;
                    for (ResultadoAluno resultado : resultados) {
                %>
                <tr>
                    <td><%= posicao++ %></td>
                    <td><%= resultado.getMatricula() %></td>
                    <td><%= resultado.getNome() %></td>
                    <td><%= resultado.getPontuacao() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
</body>
</html>
