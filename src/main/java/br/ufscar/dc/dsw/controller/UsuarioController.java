package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Usuario;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/usuarios/*")
public class UsuarioController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UsuarioDAO dao;

    @Override
    public void init() {
        dao = new UsuarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "/";
        }

        try {
            switch (action) {
                case "/novo":
                    mostraFormNovo(request, response);
                    break;
                case "/edita":
                    mostraFormEdicao(request, response);
                    break;
                case "/remove":
                    removeUsuario(request, response);
                    break;
                default:
                    listaUsuarios(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "/";
        }

        try {
            switch (action) {
                case "/insere":
                    insereUsuario(request, response);
                    break;
                case "/atualiza":
                    atualizaUsuario(request, response);
                    break;
                default:
                    response.sendRedirect("usuarios");
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // 🔍 Métodos auxiliares

    private void listaUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Usuario> lista = dao.listarTodos();
        request.setAttribute("listaUsuarios", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/lista.jsp");
        dispatcher.forward(request, response);
    }

    private void mostraFormNovo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario/form.jsp");
        dispatcher.forward(request, response);
    }

    private void mostraFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario usuario = dao.buscarPorId(id);
        request.setAttribute("usuario", usuario);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/views/usuario/form.jsp");
        dispatcher.forward(request, response);
    }

    private void insereUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String role = request.getParameter("role");

        Usuario usuario = new Usuario(null, nome, email, senha, role);
        dao.inserir(usuario);
        response.sendRedirect("usuarios");
    }

    private void atualizaUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String role = request.getParameter("role");

        Usuario usuario = new Usuario(id, nome, email, senha, role);
        dao.atualizar(usuario);
        response.sendRedirect("usuarios");
    }

    private void removeUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        dao.deletar(id);
        response.sendRedirect("usuarios");
    }
}
