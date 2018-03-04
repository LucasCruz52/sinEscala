package org.primefaces.ultima.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.huufs.sinEscala.DAO.EntityBase;
import sun.security.util.BigInt;

@Entity
@Table(schema = "public", name = "perfil")
public class Perfil implements EntityBase {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;
	
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

	@Override
	public long getId() {
		return this.id;
	}

}
