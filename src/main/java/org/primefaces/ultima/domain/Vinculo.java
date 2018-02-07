package org.primefaces.ultima.domain;

import javax.persistence.Id;

public class Vinculo {

	public static final int EBSERH = 10;
	
	public static final int UFS = 20;
	
	public static final int UFS_E_EBSERH = 30;
	
	@Id
	public int id;
	
	public String descricao;
	
	/*Cada tipo de vinculo possui um intervalo minimo de folga na Jornada, em caso de plantões 
	 * (noturnos ou diurnos) 
	 * EBSERH - 36 horas, UFS - 60 horas*/
	public int folgaJornada;
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFolgaJornada() {
		return folgaJornada;
	}

	public void setFolgaJornada(int folgaJornada) {
		this.folgaJornada = folgaJornada;
	}
	
	
	
}
