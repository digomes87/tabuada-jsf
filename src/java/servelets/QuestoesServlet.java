package servelets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import module.ResultadoService;
import module.ResultadoAluno;

@WebServlet(name = "QuestoesServlet", urlPatterns = {"/questoes"})
public class QuestoesServlet extends HttpServlet {
    
    private ResultadoService resultadoService = new ResultadoService();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");
        
        if (matricula != null && !matricula.isEmpty() && nome != null && !nome.isEmpty()) {
            // Verificar se o aluno já fez a prova
            List<ResultadoAluno> resultados = resultadoService.carregarResultados();
            boolean alunoJaFezProva = false;
            for (ResultadoAluno resultado : resultados) {
                if (resultado.getMatricula().equals(matricula)) {
                    alunoJaFezProva = true;
                    break;
                }
            }
            
            if (alunoJaFezProva) {
                // Se o aluno já fez a prova, redirecione-o para uma página informando que ele já fez a prova
                response.sendRedirect("jaFezProva.jsp");
            } else {
                // Se o aluno não fez a prova, continue com o processamento normal
                HttpSession session = request.getSession();
                session.setAttribute("matricula", matricula);
                session.setAttribute("nome", nome);
                response.sendRedirect("questoes.jsp");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Matrícula e nome são obrigatórios.");
        }
    }
}
