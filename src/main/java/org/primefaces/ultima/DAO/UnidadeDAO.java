package org.primefaces.ultima.DAO;

import org.primefaces.ultima.domain.Profissional;
import org.primefaces.ultima.domain.Restricao;
import org.primefaces.ultima.domain.UnidadeInternacao;
import org.primefaces.ultima.domain.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UnidadeDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public UnidadeInternacao cadastrarUnidade(UnidadeInternacao unidade){
        em.getTransaction().begin();

        em.persist(unidade);
        em.flush();

        UnidadeInternacao st = em.find(UnidadeInternacao.class, unidade.getId());
        System.out.println(st);

        em.getTransaction().commit();

        //em.close();
        //emf.close();

        return st;
    }
    
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
