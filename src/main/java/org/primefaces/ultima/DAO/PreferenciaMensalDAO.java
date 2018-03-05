package org.primefaces.ultima.DAO;

import org.primefaces.ultima.domain.DiaAno;
import org.primefaces.ultima.domain.PreferenciaMensal;
import org.primefaces.ultima.domain.Usuario;
import org.primefaces.ultima.service.ListaPreferenciasService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PreferenciaMensalDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public PreferenciaMensal cadastrarPrefenrenciaMensal(PreferenciaMensal preferenciaMensal){
        em.getTransaction().begin();

        em.persist(preferenciaMensal);
        em.flush();

        PreferenciaMensal st = em.find(PreferenciaMensal.class, preferenciaMensal.getId());
        System.out.println(st);

        em.getTransaction().commit();

        //em.close();
        //emf.close();

        return st;
    }

    public PreferenciaMensal pesquisarListaPreferencia(PreferenciaMensal preferenciaMensal){

        Query query = null;

        query = em.createQuery("select u from Usuario u where nome = :nome");
        query.setParameter("nome",usuario.nome);

        if(query != null) {
            listaUsuario = query.getResultList();
        }

        return listaUsuario;
    }

}
