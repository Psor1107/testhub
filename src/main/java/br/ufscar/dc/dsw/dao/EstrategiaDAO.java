package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.model.Estrategia;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class EstrategiaDAO {

    public void inserir(Estrategia estrategia) {
        String sql = "INSERT INTO Estrategia (nome, descricao, exemplos, dicas) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estrategia.getNome());
            stmt.setString(2, estrategia.getDescricao());
            stmt.setString(3, estrategia.getExemplos());
            stmt.setString(4, estrategia.getDicas());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizar(Estrategia estrategia) {
        String sql = "UPDATE Estrategia SET nome=?, descricao=?, exemplos=?, dicas=? WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, estrategia.getNome());
            stmt.setString(2, estrategia.getDescricao());
            stmt.setString(3, estrategia.getExemplos());
            stmt.setString(4, estrategia.getDicas());
            stmt.setLong(5, estrategia.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Long id) {
        String sql = "DELETE FROM Estrategia WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Estrategia buscarPorId(Long id) {
        String sql = "SELECT * FROM Estrategia WHERE id=?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return map(rs);
                }
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Estrategia> listarTodos() {
        List<Estrategia> lista = new ArrayList<>();
        String sql = "SELECT * FROM Estrategia";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                lista.add(map(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    private Estrategia map(ResultSet rs) throws SQLException {
        Estrategia estrategia = new Estrategia();
        estrategia.setId(rs.getLong("id"));
        estrategia.setNome(rs.getString("nome"));
        estrategia.setDescricao(rs.getString("descricao"));
        estrategia.setExemplos(rs.getString("exemplos"));
        estrategia.setDicas(rs.getString("dicas"));
        return estrategia;
    }
}