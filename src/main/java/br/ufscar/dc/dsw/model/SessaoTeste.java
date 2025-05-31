package br.ufscar.dc.dsw.model;

import java.time.LocalDateTime;
import java.util.List;

import br.ufscar.dc.dsw.enums.StatusSessao;

public class SessaoTeste {
    private Long id;
    private Estrategia estrategia;
    private Long idEstrategia;
    private int tempoMinutos;
    private String descricao;
    private StatusSessao status;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private List<Bug> bugs;

    // quem contem a sessao de teste
    private Projeto projeto;
    private Long idProjeto;

    // quem executa a sessao de teste
    private Tester tester;
    private Long idTester;

    // construtores
    public SessaoTeste() {
    }

    public SessaoTeste(Long idProjeto, Long idTester, Long idEstrategia, int tempoMinutos, String descricao) {
        this.idProjeto = idProjeto;
        this.idTester = idTester;
        this.idEstrategia = idEstrategia;
        this.tempoMinutos = tempoMinutos;
        this.descricao = descricao;
        this.status = StatusSessao.CRIADO;
    }

    public SessaoTeste(Long id) {
        this.id = id;
    }

    // getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tester getTester() {
        return tester;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public Long getIdTester() {
        return idTester;
    }

    public void setIdTester(Long idTester) {
        this.idTester = idTester;
    }

    public Estrategia getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(Estrategia estrategia) {
        this.estrategia = estrategia;
    }

    public Long getIdEstrategia() {
        return idEstrategia;
    }

    public void setIdEstrategia(Long idEstrategia) {
        this.idEstrategia = idEstrategia;
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

    public void setIdProjeto(Long idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Long getIdProjeto() {
        return idProjeto;
    }

    public void setBugs(List<Bug> bugs) {
        this.bugs = bugs;
    }

    public List<Bug> getBugs() {
        return bugs;
    }
}
