package org.primefaces.ultima.DAO;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.ultima.domain.Cargo;
import org.primefaces.ultima.domain.Perfil;

import br.huufs.sinEscala.DAO.GenericDAO;
import org.primefaces.ultima.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CargoDAO extends GenericDAO<Perfil, Long>{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public List<Cargo> recuperarCargos(){

        Query query = null;
        List<Cargo> listaCargos = new ArrayList<Cargo>();

        query = em.createQuery("select p from Cargo p");

        if(query != null) {
            listaCargos = query.getResultList();
        }

        return listaCargos;
    }

}
