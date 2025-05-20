package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.ufscar.dc.dsw.model.Usuario;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class UsuarioDAO {

    // q̶u̶a̶s̶e̶ ̶t̶u̶d̶o̶ ̶a̶q̶u̶i̶ ̶é̶ ̶t̶e̶m̶p̶o̶r̶a̶r̶i̶o̶,̶ ̶e̶u̶ ̶e̶s̶t̶o̶u̶ ̶s̶ó̶ ̶s̶e̶t̶a̶n̶d̶o̶ ̶a̶s̶ ̶c̶l̶a̶s̶s̶e̶s̶
    // ̶p̶r̶a̶ ̶s̶e̶ ̶p̶r̶e̶o̶c̶u̶p̶a̶r̶ ̶e̶m̶ ̶r̶e̶f̶i̶n̶a̶r̶ ̶o̶s̶ ̶r̶e̶q̶u̶i̶s̶i̶t̶o̶s̶/̶f̶u̶n̶c̶i̶o̶n̶a̶l̶i̶d̶a̶d̶e̶s̶ ̶d̶e̶p̶o̶i̶s̶

    // bom, eu acredito que tenha setado direito, mas sintam-se a vontade
    // pra checar se esta tudo de acordo
    // (serve pra todos os DAOs)
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