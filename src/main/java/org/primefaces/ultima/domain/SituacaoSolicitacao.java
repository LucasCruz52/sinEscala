/*
 * @author Pablo Lima
 * Classe de domínio que descrimina os status que uma solicitacao pode ter
 */
package org.primefaces.ultima.domain;

import javax.persistence.Id;

public class SituacaoSolicitacao {
	
	@Id
	public int id;
	
	public static final int CRIADA = 1;
	
	public static final int SUBMETIDA = 2;
	
	public static final int EM_ANALISE_SUBCHEFIA = 3;
	
	public static final int EM_ANALISE_CHEFIA = 4;
	
	public static final int ACEITA = 5;
	
	public static final int REJEITADA = 6;
	
	public String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
