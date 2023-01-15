package br.com.fiap.smartcities.rmi.server;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.rmi.RemoteException;

import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;

public class TipoEstabelecimentoServiceImpl implements TipoEstabelecimentoService {

    protected TipoEstabelecimentoServiceImpl()
            throws RemoteException {
        super();
    }

    public String pesquisar(Integer idPesquisa)
            throws RemoteException {

        EntityManager em = Persistence
                .createEntityManagerFactory("smartcities-orm")
                .createEntityManager();

        TipoEstabelecimentoDAO dao = new TipoEstabelecimentoDAO(em);

        TipoEstabelecimento tipoEstabelecimento = dao.buscar(idPesquisa);

        if (tipoEstabelecimento != null) {
            return tipoEstabelecimento.getNome();
        } else {
            return null;
        }
    }
}