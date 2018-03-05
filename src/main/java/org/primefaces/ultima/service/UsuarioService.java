package org.primefaces.ultima.service;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.Init;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.primefaces.ultima.DAO.PerfilDAO;
import org.primefaces.ultima.DAO.UsuarioDAO;
import org.primefaces.ultima.domain.Car;
import org.primefaces.ultima.domain.Perfil;
import org.primefaces.ultima.domain.Usuario;

//Imports de elementos para o uso do Hibernate funcionar import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean(name = "usuarioService")
@SessionScoped
public class UsuarioService{

    private List<Usuario> listaUsuariosEncontrados;

    private String login;
    
	private String nome;
    
    private String senha;
    
    private String email;
    
    private Date dataAtual= new Date();
    
    private Date dataExpiracao;

    private int idPerfil;

    private boolean ativo;

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataAtual() {
		return dataAtual;
	}

	public Date getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Date dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

    public List<Usuario> getListaUsuariosEncontrados() {
        return listaUsuariosEncontrados;
    }

    public void setListaUsuariosEncontrados(List<Usuario> listaUsuariosEncontrados) {
        this.listaUsuariosEncontrados = listaUsuariosEncontrados;
    }

    public void cadastrar() {
		//validar();

		Usuario obj = new Usuario();
		obj.setLogin(login);
		obj.setSenha(senha);
		obj.setNome(nome);
		obj.setEmail(email);
		Perfil perfil = new Perfil();
		perfil.setId(idPerfil);
		obj.setPerfil(perfil);
		obj.setDataCadastro(dataAtual);
		obj.setDataExpiracao(dataExpiracao);
		obj.setAtivo(true);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		Usuario usuarioSalvo = usuarioDao.cadastrarUsuario(obj);

		if(usuarioSalvo != null){
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado!","");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }else{
            FacesMessage msg = new FacesMessage("Falha no cadastro!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }

        limpar();

        //return "/cadastroUsuario.xhtml?faces-redirect=true";
	}

	public void pesquisar(){
        List<Usuario> listaUsuarios;

        Usuario obj = new Usuario();
        obj.setNome(nome);
        obj.setLogin(login);
        obj.setSenha(senha);
        obj.setEmail(email);
        obj.setAtivo(ativo);
        //obj.setPerfil(perfil);

        UsuarioDAO usuarioDao = new UsuarioDAO();
        setListaUsuariosEncontrados(usuarioDao.pesquisarUsuario(obj));
    }

	public void remover(int id) {

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "ID: " + id,"");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }
	
	public void Validar() {
		//METODO PRA VALIDACAO DOS CAMPOS
	}

	public void limpar(){
        setNome("");
        setLogin("");
        setEmail("");
        setSenha("");
        setDataExpiracao(null);
    }

}
	
