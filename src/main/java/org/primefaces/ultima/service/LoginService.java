package org.primefaces.ultima.service;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.ultima.DAO.UsuarioDAO;
import org.primefaces.ultima.domain.Usuario;

import br.huufs.sinEscala.DAO.Utils;


@ManagedBean(name = "loginService")
@SessionScoped
public class LoginService implements Serializable {
	
	private String login;
	private String senha;
	Usuario usuario = new Usuario();
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LoginService() {
		
	}
    
    public String fazerLogin() {
    	if (login == null) {
    		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário ou senha incorretos!","");
            FacesContext.getCurrentInstance().addMessage(null, msg); 
        } else {
        	UsuarioDAO udao = new UsuarioDAO();
        	List<Usuario> listaUsuario= udao.pesquisarUsuario(usuario);
        	// USE MD5!!!
            if (senha.equals(listaUsuario.iterator().next().getSenha())&&
            		login.equals(listaUsuario.iterator().next().getLogin())) {
                HttpSession session;
                FacesContext ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("usuarioAutenticado", usuario);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
            	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário ou senha incorretos!","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    	return null;
    }
    
    	/*
    	String senha = Utils.converterStringEmMD5(this.login.getSenha());
        //String hql = "SELECT vo FROM Usuario vo"
           //     + " WHERE vo.usuario='" + this.login.getLogin() + "'"
           //     + " AND vo.senha='" + senha + "'";
        Usuario verifica = (Usuario) new UsuarioDAO().pesquisarUsuario(this.login);
        if (verifica != null) {
                Utils.criarObjetoDeSessao(verifica, "usuarioLogado");
                Utils.redirecionarPagina("ultima/cadastroUsuario.xhtml");
                this.login = new Usuario();
            } else {
            Utils.criarAvisoErro("Usuário ou senha incorretos!");
        }
        }
        */
    

    public String fazerLogout() {
    	HttpSession session;

        FacesContext ctx = FacesContext.getCurrentInstance();
        session = (HttpSession) ctx.getExternalContext().getSession(false);
        session.setAttribute("usuarioAutenticado", null);
 
        Enumeration<String> vals = session.getAttributeNames(); 
        
        while(vals.hasMoreElements()){
            session.removeAttribute(vals.nextElement());
        }

        return null;
    	
    	//FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //redireciona para pagina login
       // Utils.redirecionarPagina("");
    }
}
