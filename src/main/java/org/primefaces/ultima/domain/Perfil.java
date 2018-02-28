package org.primefaces.ultima.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.huufs.sinEscala.DAO.EntityBase;

@Entity

@Table(schema = "public", name = "perfil")
public class Perfil implements EntityBase {

	public static final int ADMINISTRADOR = 1;
	public static final int TECNICO_ENF = 2;
	public static final int ENFERMEIRO = 3;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	int idPerfil;
	
	@Column(name = "nome_perfil")
	public String nome;
	
	//public String descricao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//public String getDescricao() {
	//	return descricao;
	//}
	
	//public void setDescricao(String descricao) {
	//	this.descricao = descricao;
	//}
	
	public int getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
