package org.primefaces.ultima.DAO;

import org.primefaces.ultima.domain.DiaAno;
import org.primefaces.ultima.domain.PreferenciaMensal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
