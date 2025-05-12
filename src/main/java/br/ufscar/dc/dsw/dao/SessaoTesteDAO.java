package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.enums.StatusSessao;
import br.ufscar.dc.dsw.model.Projeto;
import br.ufscar.dc.dsw.model.SessaoTeste;
import br.ufscar.dc.dsw.util.ConnectionFactory;

public class SessaoTesteDAO {

    public void inserir(SessaoTeste sessao) {
        String sql = """
            INSERT INTO SessaoTeste 
                (descricao, status, data_inicio, data_fim, tempo_minutos, projeto_id, tester_id, estrategia_id) 
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
        """;
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sessao.getDescricao());
            stmt.setString(2, sessao.getStatus().name());
            stmt.setTimestamp(3, Timestamp.valueOf(sessao.getDataInicio()));
            stmt.setTimestamp(4, sessao.getDataFim() != null ? Timestamp.valueOf(sessao.getDataFim()) : null);
            stmt.setInt(5, sessao.getTempoMinutos());
            stmt.setLong(6, sessao.getProjeto().getId());
            stmt.setLong(7, sessao.getTester().getId());
            stmt.setLong(8, sessao.getEstrategia().getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SessaoTeste> listarPorProjeto(Projeto projeto) {
        String sql = "SELECT * FROM SessaoTeste WHERE projeto_id = ?";
        List<SessaoTeste> sessoes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, projeto.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                SessaoTeste s = new SessaoTeste();
                s.setId(rs.getLong("id"));
                s.setDescricao(rs.getString("descricao"));
                s.setStatus(StatusSessao.valueOf(rs.getString("status")));
                s.setDataInicio(rs.getTimestamp("data_inicio").toLocalDateTime());
                s.setDataFim(rs.getTimestamp("data_fim") != null ? rs.getTimestamp("data_fim").toLocalDateTime() : null);
                s.setTempoMinutos(rs.getInt("tempo_minutos"));
                s.setProjeto(projeto);
                sessoes.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessoes;
    }

    // outros métodos: atualizarStatus, buscarPorId
}