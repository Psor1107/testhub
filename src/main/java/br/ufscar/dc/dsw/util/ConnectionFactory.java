package br.ufscar.dc.dsw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static Connection conexao = null;

    public static Connection getConnection() {
        if (conexao == null) {
            try {

                // ainda não criei o banco de dados
                // porém os dados iriam aqui 

                String url = "jdbc:mysql://localhost:3306/testhubdb";
                String usuario = "root";
                String senha = "";
                
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return conexao;
    }
}