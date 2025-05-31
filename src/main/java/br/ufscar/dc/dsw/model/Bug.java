package br.ufscar.dc.dsw.model;

import br.ufscar.dc.dsw.enums.Gravidade;
import br.ufscar.dc.dsw.enums.StatusBug;

public class Bug {
    private Long id;
    private Long idSessao;
    private String titulo;
    private String descricao;
    private Gravidade gravidade;
    private StatusBug status;

    public Bug() {
    }

    public Bug(Long idSessao, String titulo, String descricao, Gravidade gravidade) {
        this.idSessao = idSessao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.gravidade = gravidade;
        this.status = StatusBug.ABERTO;
    }

    public Bug(Long id, Long idSessao, String titulo, String descricao, Gravidade gravidade, StatusBug status) {
        this.id = id;
        this.idSessao = idSessao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.gravidade = gravidade;
        this.status = status;
    }

    public Bug(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setGravidade(Gravidade gravidade) {
        this.gravidade = gravidade;
    }

    public Gravidade getGravidade() {
        return gravidade;
    }

    public void setStatus(StatusBug status) {
        this.status = status;
    }

    public StatusBug getStatus() {
        return status;
    }

}
