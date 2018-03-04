package org.primefaces.ultima.DAO;

import br.huufs.sinEscala.DAO.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.primefaces.ultima.domain.Usuario;

import br.huufs.sinEscala.DAO.GenericDAO;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioDAO extends GenericDAO<Usuario, Long>{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public Usuario cadastrarUsuario(Usuario usuario){
        em.getTransaction().begin();

        em.persist(usuario);
        em.flush();

        Usuario st = em.find(Usuario.class, usuario.getId());
        System.out.println(st);

        em.getTransaction().commit();

        //em.close();
        //emf.close();

        return st;
    }

    public List<Usuario> pesquisarUsuario(Usuario usuario){

        Query query = null;
        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        query = em.createQuery("select u from Usuario u where nome = :nome");
        query.setParameter("nome",usuario.nome);

        if(query != null) {
            listaUsuario = query.getResultList();
        }

        return listaUsuario;
    }

    public void excluirUsuario(int id){

    }

}
