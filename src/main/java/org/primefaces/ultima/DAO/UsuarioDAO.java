package org.primefaces.ultima.DAO;

import org.primefaces.ultima.domain.Usuario;

import br.huufs.sinEscala.DAO.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class UsuarioDAO extends GenericDAO<Usuario, Long>{

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("sinEscala");
    static EntityManager em = emf.createEntityManager();

    public static void main(String[] a) throws Exception {

        em.getTransaction().begin();

        Usuario usuario = new Usuario("denise.valadares","senha","Denise Valadares","denise.valadares@gmail",null, new Date());

        em.persist(usuario);
        em.flush();

        Usuario st = em.find(Usuario.class, usuario.getId());
        System.out.println(st);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}
