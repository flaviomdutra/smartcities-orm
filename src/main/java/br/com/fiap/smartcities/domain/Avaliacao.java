package br.com.fiap.smartcities.domain;

import java.io.Serializable;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@IdClass(AvaliacaoId.class)
public class Avaliacao implements Serializable {

    @Id
    @JoinColumn(name = "id_usuario")
    @ManyToOne(optional = false)
    private Usuario usuario;

    @Id
    @JoinColumn(name = "id_estabelecimento")
    @ManyToOne(optional = false)
    private Estabelecimento estabelecimento;

    private int nota;

    // @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dh_avaliacao")
    private Calendar dataAvaliacao;

    public Avaliacao() {
        super();
    }

    public Avaliacao(Usuario usuario, Estabelecimento estabelecimento, int nota, Calendar dataAvaliacao) {
        this.usuario = usuario;
        this.estabelecimento = estabelecimento;
        this.nota = nota;
        this.dataAvaliacao = dataAvaliacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Calendar getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Calendar dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

}