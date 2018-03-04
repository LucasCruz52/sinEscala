package org.primefaces.ultima.DAO;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.ultima.domain.Perfil;

import br.huufs.sinEscala.DAO.GenericDAO;
import org.primefaces.ultima.domain.Usuario;
import org.primefaces.ultima.domain.Vinculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VinculoDAO extends GenericDAO<Perfil, Long>{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public List<Vinculo> recuperarVinculos(){

        Query query = null;
        List<Vinculo> listaVinculos = new ArrayList<Vinculo>();

        query = em.createQuery("select p from Vinculo p");

        if(query != null) {
            listaVinculos = query.getResultList();
        }

        return listaVinculos;
    }

}
