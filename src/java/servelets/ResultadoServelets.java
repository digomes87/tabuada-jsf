package servelets;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet(name = "ResultadoServelets", urlPatterns = {"/resultado"})
public class ResultadoServelets extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try {
        // Processar o resultado da prova
        int pontos = calcularPontuacao(request);

        // Adicionar a nota como atributo do request
        request.setAttribute("nota", pontos);

        // Recuperar matricula e nome dos parâmetros da requisição
        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");

        // Adicionar matricula e nome como atributos do request
        request.setAttribute("matricula", matricula);
        request.setAttribute("nome", nome);

        // Encaminhar para a página de resultado
        RequestDispatcher dispatcher = request.getRequestDispatcher("resultado.jsp");
        dispatcher.forward(request, response);
    } catch (Exception ex) {
        // Tratar exceção aqui
        ex.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Ocorreu um erro ao processar a solicitação.");
    }
}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    // Método para calcular a pontuação com base nas respostas
    private int calcularPontuacao(HttpServletRequest request) {
        int pontos = 0;
        int numQuestoes = 10; // Número de questões
        
        for (int i = 1; i <= numQuestoes; i++) {
            String resposta = request.getParameter("resposta" + i);
            // Aqui você deve adicionar sua lógica para validar as respostas e calcular os pontos
            // Exemplo: se a resposta estiver correta, adicione 1 ponto, caso contrário, não adicione nada
            // Se houver penalização por respostas erradas, você pode subtrair pontos
            // Atualmente, este método retorna a quantidade total de questões respondidas corretamente
            if (resposta != null && resposta.equals(String.valueOf(i * i))) {
                pontos++;
            }
        }
        
        return pontos;
    }

    @Override
    public String getServletInfo() {
        return "Servlet para processar o resultado da prova";
    }
}
