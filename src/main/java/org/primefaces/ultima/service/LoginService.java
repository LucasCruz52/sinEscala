package org.primefaces.ultima.service;

import java.io.Serializable;
import java.util.Enumeration;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.ultima.DAO.UsuarioDAO;
import org.primefaces.ultima.domain.Usuario;

import br.huufs.sinEscala.DAO.Utils;
import br.huufs.sinEscala.DAO.util.SessionUtil;

@RequestScoped
@ManagedBean(name = "loginService")
public class LoginService implements Serializable {
	
	private String login;
	private String senha;
	
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
	
	public LoginService() {
		
	}
    
    public String fazerLogin() {
    	System.out.println("autentica..");
        
        if (login.equals("admin")&&senha.equals("admin")) {
            System.out.println("Confirmou  usuario e senha ...");        
            
            
            Object b = new Object();
            
            SessionUtil.setParam("USUARIOLogado", b);
            
        return "/dashboard.xhtml?faces-redirect=true";

        } else {
            
            return null;

        }

    }

 
    	/*if (login == null) {
    		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário ou senha incorretos!","");
            FacesContext.getCurrentInstance().addMessage(null, msg); 
            return"";
        } else {
        	UsuarioDAO udao = new UsuarioDAO();
        	List<Usuario> listaUsuario= udao.pesquisarUsuario(usuario);
        	// USE MD5!!!listaUsuario.iterator().next().getSenha()listaUsuario.iterator().next().getLogin())
            if (senha.equals("okokok")&&
            		login.equals("testando")) {
                HttpSession session;
                FacesContext ctx = FacesContext.getCurrentInstance();
                session = (HttpSession) ctx.getExternalContext().getSession(false);
                session.setAttribute("usuarioAutenticado", usuario);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo!","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "/ultima/cadastroUsuario.xhtml?faces-redirect=true";
            } else {
            	FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário ou senha incorretos!","");
                FacesContext.getCurrentInstance().addMessage(null, msg);
                return "";
            }
        }
    	
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
