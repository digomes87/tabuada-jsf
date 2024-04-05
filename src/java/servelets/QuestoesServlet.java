package servelets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "QuestoesServlet", urlPatterns = {"/questoes"})
public class QuestoesServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String nome = request.getParameter("nome");
        
        if (matricula != null && !matricula.isEmpty() && nome != null && !nome.isEmpty()) {
            HttpSession session = request.getSession();
            session.setAttribute("matricula", matricula);
            session.setAttribute("nome", nome);
            response.sendRedirect("questoes.jsp");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Matrícula e nome são obrigatórios.");
        }
    }
}
