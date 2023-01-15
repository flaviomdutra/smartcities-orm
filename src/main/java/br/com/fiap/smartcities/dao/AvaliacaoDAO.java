
package br.com.fiap.smartcities.dao;

import br.com.fiap.smartcities.domain.Avaliacao;
import br.com.fiap.smartcities.domain.AvaliacaoId;
import jakarta.persistence.EntityManager;

public class AvaliacaoDAO extends GenericDAO<Avaliacao, AvaliacaoId> {

    public AvaliacaoDAO(EntityManager em) {
        super(em);
    }

}