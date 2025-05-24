package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.model.Usuario;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private UsuarioDAO dao;

    @Override
    public void init() {
        dao = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        List<Usuario> usuarios = dao.listarTodos();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            }
        }

        request.setAttribute("erro", "Email ou senha inválidos.");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/auth/login.jsp");
        dispatcher.forward(request, response);
    }
}


