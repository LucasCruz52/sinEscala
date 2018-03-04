package org.primefaces.ultima.DAO;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.ultima.domain.Perfil;

import br.huufs.sinEscala.DAO.GenericDAO;
import org.primefaces.ultima.domain.Restricao;
import org.primefaces.ultima.domain.Usuario;
import org.primefaces.ultima.domain.Vinculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RestricaoDAO extends GenericDAO<Perfil, Long>{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public List<Restricao> recuperarRestricoes(){

        Query query = null;
        List<Restricao> listaRestricoes = new ArrayList<Restricao>();

        query = em.createQuery("select p from Restricao p");

        if(query != null) {
            listaRestricoes = query.getResultList();
        }

        return listaRestricoes;
    }

}
