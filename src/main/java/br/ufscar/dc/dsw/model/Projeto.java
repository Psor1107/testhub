package br.ufscar.dc.dsw.model;

import java.time.LocalDateTime;
import java.util.List;

public class Projeto {
    private Long id;
    private String nome;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataFim;
    private List<Usuario> membros;

    // quem gerencia
    private Admin admin;

    // sessões de teste
    private List<SessaoTeste> sessoesTeste;

    // Construtores
    public Projeto() {
    }

    public Projeto(Long id) {
        this.id = id;
    }

    public Projeto(Long id, String nome, String descricao, LocalDateTime dataCriacao, LocalDateTime dataFim,
            List<Usuario> membros) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataFim = dataFim;
        this.membros = membros;
    }

    public Projeto(String nome, String descricao, LocalDateTime dataCriacao, LocalDateTime dataFim,
            List<Usuario> membros) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.dataFim = dataFim;
        this.membros = membros;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    public void setMembros(List<Usuario> membros) {
        this.membros = membros;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<SessaoTeste> getSessoesTeste() {
        return sessoesTeste;
    }

    public void setSessoesTeste(List<SessaoTeste> sessoesTeste) {
        this.sessoesTeste = sessoesTeste;
    }
}
