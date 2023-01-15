package br.com.fiap.smartcities.test;

import br.com.fiap.smartcities.domain.Estabelecimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JPATeste {

    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();

            em.getTransaction().begin();

            Estabelecimento novo = new Estabelecimento();
            novo.setNome("Escolinha Imaginação");

            em.persist(novo);

            Estabelecimento recuperado = em.find(Estabelecimento.class, 1);

            recuperado.setNome("Escola Magic");

            em.getTransaction().commit();

            Estabelecimento est = new Estabelecimento();
            est.setId(1);
            est.setNome("Bar do João");
            em.merge(est);

            em.getTransaction().begin();
            em.getTransaction().commit();

            em.getTransaction().begin();

            em.remove(recuperado);

            em.getTransaction().commit();

        } catch (Exception e) {

            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            e.printStackTrace();

        }

        if (em != null) {
            em.close();
        }
        System.exit(0);
    }
}