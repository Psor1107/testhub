package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.logging.Logger;

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

        switch (rota) {
            case "/" -> req.getRequestDispatcher("/index.jsp").forward(req, resp);
            case "/postar", "/listar" -> fazCoisa(req, resp);
            default -> req.getRequestDispatcher("/error.html").forward(req, resp);
        }
    }

    private void fazCoisa(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        // só um teste de tomcat, isso obviamente vai ser removido
        req.getRequestDispatcher("/mural.jsp").forward(req, resp);
    }
}