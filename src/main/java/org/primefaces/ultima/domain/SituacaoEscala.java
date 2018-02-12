/*
 * @author Pablo Lima
 * Classe de domínio que define os status de uma escala
 * Por boas práticas, todas as operações em uma escala devem ser feitas utilizando o nome das variáveis
 * e não o seu conteúdo.
 */

package org.primefaces.ultima.domain;

import javax.persistence.Id;

public class SituacaoEscala {
	
	@Id
	public int id;
	
	public static final int CRIADA = 1;
	
	public static final int EDITADA = 2;
	
	public static final int SUBMETIDA = 3;
	
	public static final int EM_ANALISE_CHEFIA = 4;
	
	public static final int DEVOLVIDA_PARA_AJUSTES = 5;
	
	public static final int HOMOLOGADA = 6;
	
	public static final int EXECUTADA = 7;
	
	public static final int FINALIZADA = 8;
	
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
	
	public SituacaoEscala() {
		// TODO Auto-generated constructor stub
	}
	
}
