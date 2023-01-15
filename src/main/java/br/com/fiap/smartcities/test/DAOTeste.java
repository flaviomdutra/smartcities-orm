package br.com.fiap.smartcities.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class DAOTeste {

    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = Persistence.createEntityManagerFactory("smartcities-orm").createEntityManager();
            TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);

            TipoEstabelecimento tipo = new TipoEstabelecimento();
            tipo.setNome("Boteco");

            dao.cadastrar(tipo);
            dao.commit();

            TipoEstabelecimento entidade = dao.buscar(1);

            if (entidade == null) {
                System.out.println("Não existe tipo de estabelecimento para a chave 1");
            } else {
                System.out.println(" > " + entidade.getId() + " - " + entidade.getNome());
            }

            System.out.println("Tipos de Estabelecimento:");

            for (TipoEstabelecimento entity : dao.listarOrdenadoNome()) {
                System.out.println(" > " + entity.getId() + " - " + entity.getNome());
            }

            // dao.excluir(1);
            dao.commit();

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            if (em != null) {
                em.close();
            }
            System.exit(0);
        }

    }
}