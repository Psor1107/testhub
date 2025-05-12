package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.model.Usuario;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class UsuarioDAO {

    // quase tudo aqui é temporario, eu estou só setando as classes
    // pra se preocupar em refinar os requisitos/funcionalidades depois
    
    public Usuario buscarPorEmail(String email) {
        String sql = "SELECT * FROM Usuario WHERE email = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                return new Usuario(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Usuario> listarPorUsuario(Usuario usuario) {
        String sql = "SELECT * FROM Usuario WHERE id = ?";
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, usuario.getId());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Usuario u = new Usuario(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("role")
                );
                usuarios.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    // outros métodos: atualizarStatus, buscarPorId
}