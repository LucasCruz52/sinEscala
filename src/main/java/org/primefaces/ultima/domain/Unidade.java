/*
 * @author Pablo Lima
 */

package org.primefaces.ultima.domain;

import java.util.List;

import javax.persistence.Id;


public class Unidade {
	
	
	/*Nome da Unidade*/
	public String nome;
	
	/*Descricao do departamento*/
	public String descricao;
	
	@Id
	public int id;
	
	/*Lista dos profissionais da Unidade*/
	public List<Profissional> colaboradores;
	
	/*Chefe da Unidade*/
	public Profissional subChefe;
	
	/*Sigla da Unidade*/
	public String sigla;
	
	/*Quantidade de Leitos que a Unidade dispõe*/
	public int quantidadeLeitos;
	
	/*Atributo que define se a Unidade está ativa no HU*/
	public boolean isAtiva;
	
	/*Atributo que define se a Unidade tratada é de internação*/
	public boolean isInternacao;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Profissional> getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(List<Profissional> colaboradores) {
		this.colaboradores = colaboradores;
	}

	public Profissional getSubChefe() {
		return subChefe;
	}

	public void setSubChefe(Profissional subChefe) {
		this.subChefe = subChefe;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getQuantidadeLeitos() {
		return quantidadeLeitos;
	}

	public void setQuantidadeLeitos(int quantidadeLeitos) {
		this.quantidadeLeitos = quantidadeLeitos;
	}

	public boolean isAtiva() {
		return isAtiva;
	}

	public void setAtiva(boolean isAtiva) {
		this.isAtiva = isAtiva;
	}

	public boolean isInternacao() {
		return isInternacao;
	}

	public void setInternacao(boolean isInternacao) {
		this.isInternacao = isInternacao;
	}
	
}
