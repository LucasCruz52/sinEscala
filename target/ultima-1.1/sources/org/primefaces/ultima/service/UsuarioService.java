package org.primefaces.ultima.service;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.xml.transform.Result;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.primefaces.ultima.domain.Car;
import org.primefaces.ultima.domain.Perfil;
import org.primefaces.ultima.domain.Unidade;
import org.primefaces.ultima.domain.Usuario;

//Imports de elementos para o uso do Hibernate funcionar import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean(name = "usuarioService")
@SessionScoped
public class UsuarioService{

    public Usuario usuario;

    public List<Usuario> pesquisarUsuariosCadastrados(int unidade){

        List<Usuario> lista = new ArrayList<Usuario>();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date dateRepresentation = cal.getTime();

        Usuario usuario1 = new Usuario(1,"lucas.cruz","123","lucas","lucas.cruz.52@gmail", null, dateRepresentation);
        Usuario usuario2 = new Usuario(2,"vinicius.thadeu","456","vinicius","vinicius.thadeu@gmail", null, dateRepresentation);

        lista.add(usuario1);
        lista.add(usuario2);

        return lista;
    }

    public boolean cadastrarUsuario(Usuario usuario){

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 1988);
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date dateRepresentation = cal.getTime();

        //Cria objeto que receberá as configurações
        Configuration cfg = new Configuration();

        //Informe o arquivo XML que contém a configurações
        cfg.configure("hibernate.cfg.xml");

        //Cria uma fábrica de sessões.
        //Deve existir apenas uma instância na aplicação
        SessionFactory sf = cfg.buildSessionFactory();

        // Abre sessão com o Hibernate
        Session session = sf.openSession();

        //Cria uma transação
        Transaction tx = session.beginTransaction();

        // Cria objeto Aluno
        //Usuario usuario = new Usuario(1,"lucas.cruz","123","lucas","lucas.cruz.52@gmail", null, dateRepresentation);

        session.save(usuario); // Realiza persistência
        tx.commit(); // Finaliza transação
        session.close(); // Fecha sessão

        return true;
    }

    public List<Usuario> listarUsuarios() {

        List<Usuario> lista = new ArrayList<Usuario>();

        //Cria objeto que receberá as configurações
        Configuration cfg = new Configuration();

        //Informe o arquivo XML que contém a configurações
        cfg.configure("hibernate.cfg.xml");

        //Cria uma fábrica de sessões.
        //Deve existir apenas uma instância na aplicação
        SessionFactory sf = cfg.buildSessionFactory();

        // Abre sessão com o Hibernate
        Session session = sf.openSession();

        Usuario usuario = session.get(Usuario.class,4);
        lista.add(usuario);

        return lista;
    }

    public static void main(final String[] args) throws Exception {
        UsuarioService usuarioService = new UsuarioService();
        List<Usuario> usuarios = usuarioService.listarUsuarios();

        System.out.println(usuarios.get(0).login);
    }

}
