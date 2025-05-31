package br.ufscar.dc.dsw.model;

public class Usuario {
    private Long id;
    private String nome;
    private String email; // Precisa ser único, podemos seter isso depois usando @Column(unique=true) no
                          // BD depois
    private String senha;
    private String role; // "ADMIN" ou "TESTER"

    // Construtores
    public Usuario() {
    }

    public Usuario(Long id, String nome, String email, String senha, String role) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Usuario(String nome, String email, String senha, String role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Usuario(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}