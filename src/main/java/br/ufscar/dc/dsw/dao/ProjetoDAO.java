package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.model.Admin;
import br.ufscar.dc.dsw.model.Projeto;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class ProjetoDAO {

    public void inserir(Projeto projeto) {
        String sql = "INSERT INTO Projeto (nome, descricao, data_criacao, admin_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setTimestamp(3, Timestamp.valueOf(projeto.getDataCriacao()));
            stmt.setLong(4, projeto.getAdmin().getId());
            stmt.executeUpdate();

            // Recupera o ID gerado
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                projeto.setId(rs.getLong(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Projeto> listarPorAdmin(Admin admin) {
        String sql = "SELECT * FROM Projeto WHERE admin_id = ?";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, admin.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Projeto p = new Projeto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
                p.setAdmin(admin); // Associa o Admin
                projetos.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projetos;
    }

    // outros métodos: atualizar, excluir, buscarPorId
}