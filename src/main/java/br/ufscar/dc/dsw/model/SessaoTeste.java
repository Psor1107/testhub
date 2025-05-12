package br.ufscar.dc.dsw.model;

import java.time.LocalDateTime;

import br.ufscar.dc.dsw.enums.StatusSessao;

public class SessaoTeste {
    private Long id;
    private Estrategia estrategia;
    private int tempoMinutos;
    private String descricao;
    private StatusSessao status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    // quem contem a sessao de teste
    private Projeto projeto;

    // quem executa a sessao de teste
    private Tester tester;

    // construtores
    public SessaoTeste() {
    }

    public SessaoTeste(Long id, Estrategia estrategia, int tempoMinutos, String descricao, StatusSessao status,
            LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.estrategia = estrategia;
        this.tempoMinutos = tempoMinutos;
        this.descricao = descricao;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public int getTempoMinutos() {
        return tempoMinutos;
    }

    public void setTempoMinutos(int tempoMinutos) {
        this.tempoMinutos = tempoMinutos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusSessao getStatus() {
        return status;
    }

    public void setStatus(StatusSessao status) {
        this.status = status;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }
    public Projeto getProjeto() {
        return projeto;
    }
    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
    public Tester getTester() {
        return tester;
    }
    public void setTester(Tester tester) {
        this.tester = tester;
    }
}
