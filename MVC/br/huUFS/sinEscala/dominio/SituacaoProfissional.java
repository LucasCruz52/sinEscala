/*
 * @author Pablo Lima
 * Classe de domínio que discrimina os status possiveis de um Profissional
 */

package br.huUFS.sinEscala.dominio;

import javax.persistence.Id;

public class SituacaoProfissional {
	
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
	
	/* Atributo responsavel por armazenar o periodo maximo em quantidade de dias (se houver)
	 * que cada tipo de afastamento tem por legislacao definida */
	public int periodoMaximo;
	

}
