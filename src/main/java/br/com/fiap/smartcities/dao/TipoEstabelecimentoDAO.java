
package br.com.fiap.smartcities.dao;

import jakarta.persistence.EntityManager;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class TipoEstabelecimentoDAO extends GenericDAO<TipoEstabelecimento, Integer> {

    public TipoEstabelecimentoDAO(EntityManager em) {
        super(em);
    }

    @Override
    public List<TipoEstabelecimento> listar() {
        return this.em.createQuery("from TipoEstabelecimento", TipoEstabelecimento.class).getResultList();
    }

    public List<TipoEstabelecimento> listarOrdenadoNome() {
        return this.em.createQuery("from TipoEstabelecimento order by nome", TipoEstabelecimento.class).getResultList();
    }

    public List<TipoEstabelecimento> listarTresUltimos() {
        return this.em.createQuery(
                "from TipoEstabelecimento order by id desc", TipoEstabelecimento.class)
                .setMaxResults(3)
                .getResultList();
    }

    public List<TipoEstabelecimento> listarPaginado(int itensPorPagina, int pagina) {

        int primeiro = (pagina - 1) * itensPorPagina;

        return this.em.createQuery(
                "from TipoEstabelecimento order by nome", TipoEstabelecimento.class)
                .setMaxResults(itensPorPagina)
                .setFirstResult(primeiro)
                .getResultList();
    }

    public int alterarTipoTodos(TipoEstabelecimento novoTipo) {
        em.getTransaction().begin();

        int total = this.em.createQuery(
                "update Estabelecimento e set e.tipo = :tipo")
                .setParameter("tipo", novoTipo)
                .executeUpdate();

        em.getTransaction().commit();

        return total;
    }

    public int excluirAntesDe(Calendar data) {
        em.getTransaction().begin();

        int total = this.em.createQuery("delete from Estabelecimento e "
                + "where  dataCriacao < : data").setParameter("data", data)
                .executeUpdate();

        em.getTransaction().commit();
        
        return total;
    }
}