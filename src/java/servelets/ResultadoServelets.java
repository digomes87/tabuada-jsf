package servelets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ResultadoServelets", urlPatterns = {"/resultado"})
public class ResultadoServelets extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int totalPontos = 0; // Inicializa o total de pontos
        int numQuestoes = 10; // Número de questões

        // Loop para iterar sobre cada questão
        for (int i = 1; i <= numQuestoes; i++) {
            // Obtém os números correspondentes à questão atual
            int num1 = Integer.parseInt(request.getParameter("num1" + i));
            int num2 = Integer.parseInt(request.getParameter("num2" + i));

            // Calcula o resultado esperado da multiplicação para a questão atual
            int resultadoEsperado = num1 * num2;

            // Obtém a resposta fornecida pelo usuário para a questão atual
            String resposta = request.getParameter("resposta" + i);

            // Verifica se a resposta do usuário não é nula e não está vazia
            if (resposta != null && !resposta.isEmpty()) {
                try {
                    int respostaInt = Integer.parseInt(resposta); // Convertendo a resposta para inteiro
                    if (respostaInt == resultadoEsperado) {
                        totalPontos++; // Incrementa a pontuação se a resposta estiver correta
                    }
                } catch (NumberFormatException e) {
                    // Tratar erro de conversão de string para inteiro, se necessário
                    System.out.println("Erro ao converter resposta para inteiro: " + e.getMessage());
                }
            } else {
                // Caso a resposta seja nula ou vazia, não incrementamos a pontuação
                System.out.println("Resposta nula ou vazia para a questão " + i);
            }
        }

        // Obtém a matrícula e o nome da sessão
        HttpSession session = request.getSession();
        String matricula = (String) session.getAttribute("matricula");
        String nome = (String) session.getAttribute("nome");

        // Verifica se a matrícula e o nome estão presentes na sessão
        if (matricula != null && nome != null) {
            // Encaminha para a página de resultado
            request.setAttribute("matricula", matricula);
            request.setAttribute("nome", nome);
            request.setAttribute("nota", totalPontos);
            System.out.println("Total de pontos: " + totalPontos); // Debugging: imprimir pontuação total
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Matrícula e nome são obrigatórios.");
        }
    }
}
