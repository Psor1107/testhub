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
        String sql = "INSERT INTO Estrategia (nome, descricao, exemplos, dicas, admin_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, estrategia.getNome());
            stmt.setString(2, estrategia.getDescricao());
            stmt.setString(3, estrategia.getExemplos());
            stmt.setString(4, estrategia.getDicas());
            stmt.setLong(5, estrategia.getAdmin().getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Estrategia> listarTodas() {
        String sql = "SELECT * FROM Estrategia";
        List<Estrategia> estrategias = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estrategia e = new Estrategia();
                e.setId(rs.getLong("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                e.setExemplos(rs.getString("exemplos"));
                e.setDicas(rs.getString("dicas"));
                estrategias.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estrategias;
    }

    // outros métodos: atualizar, excluir, buscarPorId
}