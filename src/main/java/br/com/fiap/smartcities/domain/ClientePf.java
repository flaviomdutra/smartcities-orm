package br.com.fiap.smartcities.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente_pf")
public class ClientePf extends Cliente {

    @Column(name = "estado_civil", length = 20)
    private String estadoCivil;

    @Column(length = 20)
    private String escolaridade;

    public ClientePf() {
        super();
    }

    public ClientePf(String estadoCivil, String escolaridade) {
        this.estadoCivil = estadoCivil;
        this.escolaridade = escolaridade;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

}