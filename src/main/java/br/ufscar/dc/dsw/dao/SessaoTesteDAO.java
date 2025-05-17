package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import br.ufscar.dc.dsw.model.SessaoTeste;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class SessaoTesteDAO {

    public void inserir(SessaoTeste sessao) {
        String sql = "INSERT INTO SessaoTeste (estrategia_id, tempoMinutos, descricao, status, dataInicio, dataFim, projeto_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, sessao.getEstrategia().getId());
            stmt.setInt(2, sessao.getTempoMinutos());
            stmt.setString(3, sessao.getDescricao());
            stmt.setString(4, sessao.getStatus().name());
            if (sessao.getDataInicio() != null) {
                stmt.setTimestamp(5, Timestamp.valueOf(sessao.getDataInicio()));
            } else {
                stmt.setTimestamp(5, null);
            }
            if (sessao.getDataFim() != null) {
                stmt.setTimestamp(6, Timestamp.valueOf(sessao.getDataFim()));
            } else {
                stmt.setTimestamp(6, null);
            }
            stmt.setLong(7, sessao.getProjeto().getId());

            stmt.executeUpdate();

            try (var rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    sessao.setId(rs.getLong(1));
                }
            }
            if (sessao.getTesters() != null) {
                for (var tester : sessao.getTesters()) {
                    inserirTester(sessao.getId(), tester.getId());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirTester(Long sessaoTesteId, Long testerId) {
        String sql = "INSERT INTO SessaoTeste_Tester (sessaoTeste_id, tester_id) VALUES (?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, sessaoTesteId);
            stmt.setLong(2, testerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removerTester(Long sessaoTesteId, Long testerId) {
        String sql = "DELETE FROM SessaoTeste_Tester WHERE sessaoTeste_id = ? AND tester_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, sessaoTesteId);
            stmt.setLong(2, testerId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // outros métodos: atualizarStatus, buscarPorId
}