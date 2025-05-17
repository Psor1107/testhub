package br.ufscar.dc.dsw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/testhub_db;create=true";
            String usuario = "app";
            String senha = "app";
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Driver Derby Client não encontrado!", ex);
        }
    }
}