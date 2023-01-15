package br.com.fiap.smartcities.dao;

import br.com.fiap.smartcities.domain.Cliente;
import jakarta.persistence.EntityManager;

public class ClienteDAO extends GenericDAO<Cliente, Integer> {

    public ClienteDAO(EntityManager em) {
        super(em);
    }

}
