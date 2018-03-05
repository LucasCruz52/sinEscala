package org.primefaces.ultima.DAO;

import org.primefaces.ultima.domain.PreferenciaDiaria;
import org.primefaces.ultima.domain.PreferenciaMensal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PreferenciaDiariaDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public List<PreferenciaDiaria> cadastrarPreferenciasDiarias(List<PreferenciaDiaria> listaPreferenciasDiarias){
        em.getTransaction().begin();

        for(int i = 0; i < listaPreferenciasDiarias.size(); i++) {
            em.persist(listaPreferenciasDiarias.get(i));
            em.flush();
        }

        List<PreferenciaDiaria> st = new ArrayList<PreferenciaDiaria>();

        for(int i = 0; i < listaPreferenciasDiarias.size(); i++){
            st.add(em.find(PreferenciaDiaria.class, listaPreferenciasDiarias.get(i).getId()));
        }

        em.getTransaction().commit();

        //em.close();
        //emf.close();

        return st;
    }

}
