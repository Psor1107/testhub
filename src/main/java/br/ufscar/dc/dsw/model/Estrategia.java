package br.ufscar.dc.dsw.model;

public class Estrategia {
    private long id;
    private String nome;
    private String descricao;
    private String exemplos;
    private String dicas;

    // quem cadastrou a estrategia
    private Admin admin;

    // Construtores
    public Estrategia() {
    }

    public Estrategia(long id, String nome, String descricao, String exemplos, String dicas) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.exemplos = exemplos;
        this.dicas = dicas;
    }

    // Getters e Setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getExemplos() {
        return exemplos;
    }
    public void setExemplos(String exemplos) {
        this.exemplos = exemplos;
    }
    public String getDicas() {
        return dicas;
    }
    public void setDicas(String dicas) {
        this.dicas = dicas;
    }
    public Admin getAdmin() {
        return admin;
    }
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
