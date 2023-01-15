package br.com.fiap.smartcities.domain;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "contrato_aluguel")
public class ContratoAluguel {

    @Id
    @Column(name = "id_contrato")
    private int id;

    @Column(name = "valor_contrato", nullable = false)
    private float valor;

    public ContratoAluguel() {
        super();
    }

    public ContratoAluguel(int id, float valor, Calendar dataVencimento, Estabelecimento estabelecimento) {
        this.id = id;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.estabelecimento = estabelecimento;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento", nullable = false)
    private Calendar dataVencimento;

    @OneToOne
    @JoinColumn(name = "id_estabelecimento")
    private Estabelecimento estabelecimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Calendar getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Calendar dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

}