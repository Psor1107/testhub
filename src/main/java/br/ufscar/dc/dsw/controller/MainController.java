package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import br.ufscar.dc.dsw.dao.ProjetoDAO;
import br.ufscar.dc.dsw.model.Projeto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/app/*"})
public class MainController extends HttpServlet {

    private static Logger logger = Logger.getLogger(MainController.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rota = req.getPathInfo() != null ? req.getPathInfo() : "/"; 

        // isso óbviamente não vai ficar assim
        // mas eu precisava de uma forma de debugar
        // diferentes jsp ao mesmo tempo
        switch (rota) {
            case "/" -> req.getRequestDispatcher("/mural.jsp").forward(req, resp);
            case "/postar", "/listar" -> fazCoisa(req, resp);
            case "/teste" -> executaTeste(req, resp);
            default -> req.getRequestDispatcher("/error.html").forward(req, resp);
        }
    }

    private void fazCoisa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // faz coisa, agora faz coisas...
        ProjetoDAO projetoDAO = new ProjetoDAO();
        List<Projeto> projetos = projetoDAO.listarTodos();
        req.setAttribute("projetos", projetos);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private void executaTeste(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        
        // gera dados unicos para evitar duplicidade

        // isso aqui é só um bolo de nada pra testar
        // indiferente, vai ser excluido no proximo commit

        String unique = String.valueOf(System.currentTimeMillis());
        String nome = "Luis_" + unique;
        String email = "admin" + unique + "@email.com";
        br.ufscar.dc.dsw.dao.UsuarioDAO usuarioDAO = new br.ufscar.dc.dsw.dao.UsuarioDAO();
        br.ufscar.dc.dsw.dao.ProjetoDAO projetoDAO = new br.ufscar.dc.dsw.dao.ProjetoDAO();
        br.ufscar.dc.dsw.model.Usuario u = new br.ufscar.dc.dsw.model.Usuario(null, nome, email, "123", "ADMIN");
        usuarioDAO.inserir(u);
        java.util.List<br.ufscar.dc.dsw.model.Usuario> membros = new java.util.ArrayList<>();
        membros.add(u);
        String nomeProjeto = "Projeto Teste " + unique;
        br.ufscar.dc.dsw.model.Projeto p = new br.ufscar.dc.dsw.model.Projeto(null, nomeProjeto, "Descrição gerada em " + unique, java.time.LocalDateTime.now(), java.time.LocalDateTime.now().plusDays(10), membros);
        projetoDAO.inserir(p);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<html><body><h2>Usuário e projeto inseridos com sucesso!</h2><p>ID do usuário: " + u.getId() + "</p><p>Email: " + u.getEmail() + "</p><p>ID do projeto: " + p.getId() + "</p><p>Nome do projeto: " + p.getNome() + "</p></body></html>");
    }
}