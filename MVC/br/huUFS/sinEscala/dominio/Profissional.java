/*
 * @author Pablo Lima 
 * 
 * Classe de Dominio que armazena as informacoes referntes ao profissionais de Saude da Divisao 
 * de Enfermagem
 */

package br.huUFS.sinEscala.dominio;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Columns;
import org.joda.time.DateTime;


public class Profissional {
	
	public static final int ENFERMEIRO = 1;
	
	public static final int AUX_ENFERMAGEM = 2;
	
	public static final int TEC_ENFERMAGEM = 3;
	
	
		
	@Id 
	int id;
	
	public String nome;
	
	public String siape;
	
	public String numRegClasse;
	
	public CargaHoraria cargaHoraria;
	
	public int turnoTrabalho;
	
	public Vinculo vinculo;
	
	public int cargo;
	
	public boolean isUFS;
	
	public boolean isChefe;
	
	public boolean isSubchefe;
 	
	public boolean isPlantonista;
	
	public String telefoneContato1;
	
	public String telefoneContato2;
	
	public Unidade unidade;
	
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

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	public String getNumRegClasse() {
		return numRegClasse;
	}

	public void setNumRegClasse(String numRegClasse) {
		this.numRegClasse = numRegClasse;
	}

	public CargaHoraria getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(CargaHoraria cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getTurnoTrabalho() {
		return turnoTrabalho;
	}

	public void setTurnoTrabalho(int turnoTrabalho) {
		this.turnoTrabalho = turnoTrabalho;
	}

	public Vinculo getVinculo() {
		return vinculo;
	}

	public void setVinculo(Vinculo vinculo) {
		this.vinculo = vinculo;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public boolean isUFS() {
		return isUFS;
	}

	public void setUFS(boolean isUFS) {
		this.isUFS = isUFS;
	}

	public boolean isChefe() {
		return isChefe;
	}

	public void setChefe(boolean isChefe) {
		this.isChefe = isChefe;
	}

	public boolean isSubchefe() {
		return isSubchefe;
	}

	public void setSubchefe(boolean isSubchefe) {
		this.isSubchefe = isSubchefe;
	}

	public boolean isPlantonista() {
		return isPlantonista;
	}

	public void setPlantonista(boolean isPlantonista) {
		this.isPlantonista = isPlantonista;
	}

	public String getTelefoneContato1() {
		return telefoneContato1;
	}

	public void setTelefoneContato1(String telefoneContato1) {
		this.telefoneContato1 = telefoneContato1;
	}

	public String getTelefoneContato2() {
		return telefoneContato2;
	}

	public void setTelefoneContato2(String telefoneContato2) {
		this.telefoneContato2 = telefoneContato2;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}


	
	
	
	
}
