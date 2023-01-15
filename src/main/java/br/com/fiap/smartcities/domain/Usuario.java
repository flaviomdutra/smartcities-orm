package br.com.fiap.smartcities.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Usuario {

    @Id
    @SequenceGenerator(name = "usuario", sequenceName = "sq_usuario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    private int id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @Column(length = 12, nullable = false)
    private String usuario;

    public Usuario() {
        super();
    }

    public Usuario(int id, String nome, String senha, String usuario) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}