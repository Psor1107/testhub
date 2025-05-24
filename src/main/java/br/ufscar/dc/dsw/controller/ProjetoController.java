//package br.ufscar.dc.dsw.controller;
//
//import br.ufscar.dc.dsw.model.Projeto;
////import br.ufscar.dc.dsw.service.ProjetoService;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.List;
//
//@WebServlet("/projeto/*")
//public class ProjetoController extends HttpServlet {
//    private final ProjetoService service = new ProjetoService();
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getPathInfo();
//
//        try {
//            if (action == null || action.equals("/listar")) {
//                listar(req, resp);
//            } else if (action.equals("/cadastrar")) {
//                req.getRequestDispatcher("/jsp/projeto/form.jsp").forward(req, resp);
//            } else if (action.equals("/editar")) {
//                editar(req, resp);
//            } else if (action.equals("/deletar")) {
//                deletar(req, resp);
//            } else {
//                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//            }
//        } catch (SQLException | ServletException e) {
//            throw new ServletException(e);
//        }
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getPathInfo();
//
//        try {
//            if (action == null || action.equals("/salvar")) {
//                salvar(req, resp);
//            }
//        } catch (Exception e) {
//            req.setAttribute("erro", e.getMessage());
//            req.getRequestDispatcher("/erro.jsp").forward(req, resp);
//        }
//    }
//
//    private void listar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
//        List<Projeto> lista = service.listarProjetos();
//        req.setAttribute("projetos", lista);
//        req.getRequestDispatcher("/jsp/projeto/lista.jsp").forward(req, resp);
//    }
//
//    private void salvar(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        String nome = req.getParameter("nome");
//        String descricao = req.getParameter("descricao");
//
//        Projeto projeto = new Projeto();
//        projeto.setNome(nome);
//        projeto.setDescricao(descricao);
//
//        String idStr = req.getParameter("id");
//        if (idStr == null || idStr.isBlank()) {
//            service.cadastrarProjeto(projeto);
//        } else {
//            projeto.setId(Long.parseLong(idStr));
//            service.atualizarProjeto(projeto);
//        }
//
//        resp.sendRedirect(req.getContextPath() + "/projeto/listar");
//    }
//
//    private void editar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
//        Long id = Long.parseLong(req.getParameter("id"));
//        Projeto projeto = service.buscarPorId(id);
//        req.setAttribute("projeto", projeto);
//        req.getRequestDispatcher("/jsp/projeto/form.jsp").forward(req, resp);
//    }
//
//    private void deletar(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
//        Long id = Long.parseLong(req.getParameter("id"));
//        service.deletarProjeto(id);
//        resp.sendRedirect(req.getContextPath() + "/projeto/listar");
//    }
//}
