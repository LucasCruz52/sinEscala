package org.primefaces.ultima.service;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.ultima.DAO.UnidadeDAO;
import org.primefaces.ultima.domain.UnidadeInternacao;

@ManagedBean(name="unidadeService")
@SessionScoped
public class CadastroUnidadeService {

	 protected String nome;
	 
	 protected String descricao;
	 
	 protected String sigla;
	 
	 public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getSigla() {
			return sigla;
		}

		public void setSigla(String sigla) {
			this.sigla = sigla;
		}

		public void cadastrar() {
			UnidadeInternacao obj = new UnidadeInternacao();
			obj.setNome(nome);
			obj.setDescricao(descricao);
			obj.setSigla(sigla);
			
			UnidadeDAO uDao = new UnidadeDAO();
			UnidadeInternacao unidadeSalva = uDao.cadastrarUnidade(obj);
			if(unidadeSalva != null){
	            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário cadastrado!","");
	            FacesContext.getCurrentInstance().addMessage(null, msg);
	        }

	        limpar();
		}
	 
		public void limpar(){
	        setNome("");
	        setDescricao("");
	        setSigla("");
	    }
}
