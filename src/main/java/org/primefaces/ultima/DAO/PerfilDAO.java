package org.primefaces.ultima.DAO;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.ultima.domain.Perfil;

import br.huufs.sinEscala.DAO.GenericDAO;
import org.primefaces.ultima.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PerfilDAO extends GenericDAO<Perfil, Long>{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public List<Perfil> recuperarPerfis(){

        Query query = null;
        List<Perfil> listaPerfis = new ArrayList<Perfil>();

        query = em.createQuery("select p from Perfil p");

        if(query != null) {
            listaPerfis = query.getResultList();
        }

        return listaPerfis;
    }

    public static Perfil recuperarPerfilPorID(int id){

        Query query = null;
        Perfil perfilEncontrado = new Perfil();

        query = em.createQuery("select p from Perfil p where p.id = :id");
        query.setParameter("id", id);

        perfilEncontrado = (Perfil) query.getSingleResult();

        return perfilEncontrado;
    }


}
