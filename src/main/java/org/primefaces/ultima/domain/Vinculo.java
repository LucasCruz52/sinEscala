package org.primefaces.ultima.domain;

import javax.persistence.Id;

public class Vinculo {

	@Id
	private int id;

    private String nome;

    private String descricao;

    private CargaHorariaDiaria cargaHorariaDiaria;

    private CargaHorariaMensal cargaHorariaMensal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public CargaHorariaDiaria getCargaHorariaDiaria() {
        return cargaHorariaDiaria;
    }

    public void setCargaHorariaDiaria(CargaHorariaDiaria cargaHorariaDiaria) {
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }

    public CargaHorariaMensal getCargaHorariaMensal() {
        return cargaHorariaMensal;
    }

    public void setCargaHorariaMensal(CargaHorariaMensal cargaHorariaMensal) {
        this.cargaHorariaMensal = cargaHorariaMensal;
    }
}
