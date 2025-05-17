package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.ufscar.dc.dsw.model.Usuario;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class UsuarioDAO {

    // quase tudo aqui é temporario, eu estou só setando as classes
    // pra se preocupar em refinar os requisitos/funcionalidades depois

    public void inserir(Usuario usuario) {
        String sql = "INSERT INTO Usuario (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getRole());

            stmt.executeUpdate();

            try (java.sql.ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // outros métodos: atualizarStatus, buscarPorId
}