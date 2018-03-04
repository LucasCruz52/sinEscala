package org.primefaces.ultima.domain;

import javax.persistence.*;

@Entity
@Table(name = "cargaHorariaDiaria", schema = "public")
public class CargaHorariaDiaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	public int id;

    @ManyToOne
    @JoinColumn(name = "intervalo_id")
	private Intervalo intervalo;

    @ManyToOne
    @JoinColumn(name = "restricao_id")
	private Restricao restricao;

    @Column(name = "sigla")
	private String sigla;

    @Column(name = "descricao")
	private String descricao;

    @Column(name = "duracao")
	private int duracao;
	
	public CargaHorariaDiaria() {
		// TODO Auto-generated constructor stub
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Restricao getRestricao() {
        return restricao;
    }

    public void setRestricao(Restricao restricao) {
        this.restricao = restricao;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
}
