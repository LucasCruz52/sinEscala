package org.primefaces.ultima.service;

import java.util.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.primefaces.ultima.DAO.UsuarioDAO;
import org.primefaces.ultima.domain.Perfil;
import org.primefaces.ultima.domain.Usuario;

//Imports de elementos para o uso do Hibernate funcionar import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean(name = "usuarioService")
@SessionScoped
public class UsuarioService{

    private String login;
    
	private String nome;
    
    private String senha;
    
    private String email;
    
    private Date dataAtual= new Date();
    
    private Date dataExpiracao;
   
    private int idPerfil;
    
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

	public int getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	public String Cadastrar() {
		//validar();
		Usuario obj = new Usuario();
		obj.setDataCadastro(dataAtual);
		obj.setDataExpiracao(dataExpiracao);
		obj.setNome(nome);
		obj.setLogin(login);
		obj.setSenha(senha);
		obj.getPerfil().setIdPerfil(idPerfil);
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		usuarioDao.salvar(obj);
		return "SIM";
	}
	
	public void Validar() {
		//METODO PRA VALIDACAO DOS CAMPOS
	}
}
	
