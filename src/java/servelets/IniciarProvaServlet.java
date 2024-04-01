package servelets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import module.Prova;

@WebServlet(name = "IniciarProvaServlet", urlPatterns = {"/iniciar-prova"})
public class IniciarProvaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtendo os parâmetros do formulário
        int numeroMatricula = Integer.parseInt(request.getParameter("numeroMatricula"));
        String nomeAluno = request.getParameter("nomeAluno");
        
        // Verificando se a matrícula já está na lista de alunos que fizeram a prova
        HttpSession session = request.getSession();
        ArrayList<Prova> provas = (ArrayList<Prova>) getServletContext().getAttribute("provas");
        if (provas == null) {
            provas = new ArrayList<>();
            getServletContext().setAttribute("provas", provas);
        }
        for (Prova prova : provas) {
            if (prova.getNumeroMatricula() == numeroMatricula) {
                // Matrícula já existe, não é possível iniciar uma nova prova
                request.setAttribute("mensagem", "Você já fez a prova.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        }
        
        // Inicializando a prova para o aluno
        List<Integer> respostas = new ArrayList<>();
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            int num1 = rnd.nextInt(8) + 2; // Gera um número entre 2 e 9
            int num2 = rnd.nextInt(8) + 2; // Gera um número entre 2 e 9
            respostas.add(num1 * num2);
        }
        session.setAttribute("respostas", respostas);
        
        // Criando e adicionando a prova à lista de provas
        Prova novaProva = new Prova(numeroMatricula, nomeAluno, new Date(), 0.0);
        provas.add(novaProva);
        
        // Redirecionando para a página de questões
        response.sendRedirect("questoes.jsp");
    }
}
