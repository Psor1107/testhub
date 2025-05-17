package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    // outros métodos: atualizar, excluir, buscarPorId
}