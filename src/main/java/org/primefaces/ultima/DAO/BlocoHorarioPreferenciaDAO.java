package org.primefaces.ultima.DAO;

import org.primefaces.ultima.domain.BlocoHorarioPreferencia;
import org.primefaces.ultima.domain.PreferenciaDiaria;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class BlocoHorarioPreferenciaDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public List<BlocoHorarioPreferencia> cadastrarBlocosHorarioPreferencia(List<BlocoHorarioPreferencia> listaBlocoHorarioPreferencia){
        em.getTransaction().begin();

        for(int i = 0; i < listaBlocoHorarioPreferencia.size(); i++) {
            em.persist(listaBlocoHorarioPreferencia.get(i));
            em.flush();
        }

        List<BlocoHorarioPreferencia> st = new ArrayList<BlocoHorarioPreferencia>();

        for(int i = 0; i < listaBlocoHorarioPreferencia.size(); i++){
            st.add(em.find(BlocoHorarioPreferencia.class, listaBlocoHorarioPreferencia.get(i).getId()));
        }

        em.getTransaction().commit();

        //em.close();
        //emf.close();

        return st;
    }
}
