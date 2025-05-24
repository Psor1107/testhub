package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.model.Projeto;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class ProjetoDAO {

    public void inserir(Projeto projeto) {
        String sql = "INSERT INTO Projeto (nome, descricao, dataCriacao, dataFim) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(projeto.getDataCriacao()));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(projeto.getDataFim()));

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    projeto.setId(rs.getLong(1));
                }
            }
            
            if (projeto.getAdmin() != null) {
                inserirAdmin(projeto.getId(), projeto.getAdmin().getId());
            }

            if (projeto.getMembros() != null) {
                for (var usuario : projeto.getMembros()) {
                    inserirMembro(projeto.getId(), usuario.getId());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirMembro(Long projetoId, Long usuarioId) {
        String sql = "INSERT INTO Projeto_Membro (projeto_id, usuario_id) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, projetoId);
            stmt.setLong(2, usuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirAdmin(Long projetoId, Long adminId) {
        String sql = "INSERT INTO Projeto_Admin (projeto_id, admin_id) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, projetoId);
            stmt.setLong(2, adminId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerMembro(Long projetoId, Long usuarioId) {
        String sql = "DELETE FROM Projeto_Membro WHERE projeto_id = ? AND usuario_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, projetoId);
            stmt.setLong(2, usuarioId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerAdmin(Long projetoId, Long adminId) {
        String sql = "DELETE FROM Projeto_Admin WHERE projeto_id = ? AND admin_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, projetoId);
            stmt.setLong(2, adminId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Projeto> listarTodos() {
        String sql = "SELECT * FROM Projeto";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setId(rs.getLong("id"));
                projeto.setNome(rs.getString("nome"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setDataCriacao(rs.getTimestamp("dataCriacao").toLocalDateTime());
                projeto.setDataFim(rs.getTimestamp("dataFim").toLocalDateTime());
                projetos.add(projeto);
            }

            if (projetos.isEmpty()) {
                return new ArrayList<>();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projetos;
    }

    public Projeto buscarPorId(Long id) {
        String sql = "SELECT * FROM Projeto WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Projeto projeto = new Projeto();
                    projeto.setId(rs.getLong("id"));
                    projeto.setNome(rs.getString("nome"));
                    projeto.setDescricao(rs.getString("descricao"));
                    projeto.setDataCriacao(rs.getTimestamp("dataCriacao").toLocalDateTime());
                    projeto.setDataFim(rs.getTimestamp("dataFim").toLocalDateTime());
                    return projeto;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void atualizar(Projeto projeto) {
        String sql = "UPDATE Projeto SET nome = ?, descricao = ?, dataCriacao = ?, dataFim = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(projeto.getDataCriacao()));
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(projeto.getDataFim()));
            stmt.setLong(5, projeto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Long id) {
        String sql = "DELETE FROM Projeto WHERE id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}