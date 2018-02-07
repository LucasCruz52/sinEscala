/*
 * @author Pablo Lima
 * Classe de domínio que discrimina os status possiveis de um Profissional
 */

package org.primefaces.ultima.domain;

import javax.persistence.Id;

public class StatusProfissional {
	
	@Id
	public int id;
	
	public static final int ATIVO = 1;
	
	public static final int APOSENTADO = 2;
	
	public static final int FERIAS = 3;
	
	public static final int LICENCA_MATERNIDADE = 4;
	
	public static final int LICENCA_PATERNIDADE = 5;
	
	public static final int LICENCA_CAPACITACAO = 6;
	
	public static final int LICENCA_MEDICA = 7;
	
	public static final int EM_FOLGA = 8;
	
	public static final int ABONO = 9;
	
	public String descricao;
	
	public String sigla;

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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	

}
