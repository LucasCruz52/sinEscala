package org.primefaces.ultima.DAO;

import org.primefaces.ultima.domain.Profissional;
import org.primefaces.ultima.domain.Restricao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UnidadeDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public List<Profissional> recuperarTodosProfissionais(){

        Query query = null;
        List<Profissional> listaProfissionais = new ArrayList<Profissional>();

        query = em.createQuery("select p from Profissional p");

        if(query != null) {
            listaProfissionais = query.getResultList();
        }

        return listaProfissionais;
    }
}
