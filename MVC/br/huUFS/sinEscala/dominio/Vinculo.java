package br.huUFS.sinEscala.dominio;

import javax.persistence.Id;

public class Vinculo {

	public static final int EBSERH = 10;
	
	public static final int UFS = 20;
	
	public static final int UFS_E_EBSERH = 30;
	
	/* Metodos e atributos referente ao vinculo empregaticio:
	 * qtd de horas a serem folgadas
	 * jornada maxima e outras coisas 
	 * 
	 */
	
	@Id
	public int id;
	
	public int intervaloMinimo;
	
	public String descricao;

	public int getIntervaloMinimo() {
		return intervaloMinimo;
	}

	public void setIntervaloMinimo(int intervaloMinimo) {
		this.intervaloMinimo = intervaloMinimo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
