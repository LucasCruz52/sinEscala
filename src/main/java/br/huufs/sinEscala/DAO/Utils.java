package br.huufs.sinEscala.DAO;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.primefaces.context.RequestContext;

import org.primefaces.ultima.domain.Usuario;

import br.huufs.sinEscala.DAO.util.HibernateUtil;

public class Utils {
	public static Session pegarSessao() {
        return HibernateUtil.getSessionFactory().getCurrentSession();
    }

    public static void criarAviso(String txt) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, txt, txt);
        FacesContext.getCurrentInstance().addMessage(txt, msg);
    }

    public static void criarAvisoErro(String txt) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, txt, txt);
        FacesContext.getCurrentInstance().addMessage(txt, msg);
    }

    public static void resetarFormulario(String id) {
        RequestContext.getCurrentInstance().reset(id);
    }
    
    public static void atualizarForm(String id) {
        RequestContext.getCurrentInstance().update(id);
    }
    
    public static String converterStringEmMD5(String s) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(s.getBytes(), 0, s.length());
            BigInteger i = new BigInteger(1, m.digest());
            s = String.format("%1$032x", new Object[]{i});
        } catch (NoSuchAlgorithmException e) {
        }
        return s;
    }
    public static Connection pegarConexao() {

        Connection conexao = null;

        try {
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
            }
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5433/sinEscala",
                    "postgres",
                    "sashayaway");
        } catch (SQLException ex) {
        }
        return conexao;
    }

    public static void criarObjetoDeSessao(Object obj, String nome) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
        session.setAttribute(nome, obj);
    }

    public static Object pegarObjetoDaSessao(String nomeSessao) {
        HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return sessao.getAttribute(nomeSessao);
    }

    public static void redirecionarPagina(String pagina) {
        String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url + "/" + pagina);
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Integer usuarioLogado() {
        Usuario usuariol = (Usuario) Utils.pegarObjetoDaSessao("usuarioLogado");
        return usuariol.getId();
    }
    /*
    public String nomeUsuario(Long id) {
        String hql = "SELECT vo FROM Usuario vo"
                + " WHERE vo.id=" + id + "";
        Usuario usuario = new UsuarioDAO().pesquisarUsuario(hql);
        if (usuario != null) {
            return usuario.getNome();
        }
        return "-";
    }
    */
}
