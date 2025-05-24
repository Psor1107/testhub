//package br.ufscar.dc.dsw.service;
//
//import br.ufscar.dc.dsw.dao.ProjetoDAO;
//import br.ufscar.dc.dsw.model.Projeto;
//import br.ufscar.dc.dsw.util.ConnectionFactory;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.List;
//
//public class ProjetoService {
//
//    public void cadastrarProjeto(Projeto projeto) throws Exception {
//        if (projeto.getNome() == null || projeto.getNome().isBlank()) {
//            throw new Exception("O nome do projeto é obrigatório.");
//        }
//
//        projeto.setDataCriacao(LocalDate.now());
//
//        try (Connection conn = ConnectionFactory.getConnection()) {
//            ProjetoDAO dao = new ProjetoDAO(conn);
//            dao.inserir(projeto);
//        }
//    }
//
//    public List<Projeto> listarProjetos() throws SQLException {
//        try (Connection conn = ConnectionFactory.getConnection()) {
//            ProjetoDAO dao = new ProjetoDAO(conn);
//            return dao.listarTodos();
//        }
//    }
//
//    public Projeto buscarPorId(Long id) throws SQLException {
//        try (Connection conn = ConnectionFactory.getConnection()) {
//            ProjetoDAO dao = new ProjetoDAO(conn);
//            return dao.buscarPorId(id);
//        }
//    }
//
//    public void atualizarProjeto(Projeto projeto) throws SQLException {
//        try (Connection conn = ConnectionFactory.getConnection()) {
//            ProjetoDAO dao = new ProjetoDAO(conn);
//            dao.atualizar(projeto);
//        }
//    }
//
////    public void deletarProjeto(Long id) throws SQLException {
////        try (Connection conn = ConnectionFactory.getConnection()) {
////            ProjetoDAO dao = new ProjetoDAO(conn);
////            dao.deletar(id);
////        }
//    }
//}
