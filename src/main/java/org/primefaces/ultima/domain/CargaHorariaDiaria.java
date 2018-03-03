package org.primefaces.ultima.domain;

import javax.persistence.Id;

public class CargaHorariaDiaria {

	@Id
	public int id;

	private int turno;

	private Intervalo intervalo;

	private Restricao restricao;
	
	private String sigla;
	
	private String descricao;
	
	public CargaHorariaDiaria() {
		// TODO Auto-generated constructor stub
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public Intervalo getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Intervalo intervalo) {
        this.intervalo = intervalo;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
