package org.primefaces.ultima.domain;

import javax.persistence.Id;

public class CargaHorariaDiaria {

	@Id
	public int id;
	
	public static final int MATUTINO = 100;
	
	public static final int VESPERTINO = 200;
		
	public static final int PLANTAO_NOTURNO = 300;
	
	public int turno;
	
	public String sigla;
	
	public String descricao;
	
	public CargaHorariaDiaria() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
