/*
 * @author Pablo Lima 
 * 
 * Classe de Dominio que armazena as informacoes referntes ao profissionais de Saude da Divisao 
 * de Enfermagem
 */

package org.primefaces.ultima.domain;

import javax.persistence.*;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.List;

public class Profissional {
	
	public static final int ENFERMEIRO = 1;
	
	public static final int AUX_ENFERMAGEM = 2;
	
	public static final int TEC_ENFERMAGEM = 3;
	
	@Id 
	int id;
	
	public String nome;
	
	public String siape;
	
	public String numRegClasse;
	
	public CargaHorariaDiaria cargaHoraria;
	
	public int turnoTrabalho;
	
	public Horario horario = new Horario();
	
	public int cargo;
	
	public boolean isUFS;
	
	public boolean isChefe;
	
	public boolean isSubchefe;
 	
	public boolean isPlantonista;
	
	public String telefoneContato1;
	
	public String telefoneContato2;
	
	public Unidade unidade = new Unidade();
	
	public StatusProfissional status = new StatusProfissional();

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

	public CargaHorariaDiaria getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(CargaHorariaDiaria cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getTurnoTrabalho() {
		return turnoTrabalho;
	}

	public void setTurnoTrabalho(int turnoTrabalho) {
		this.turnoTrabalho = turnoTrabalho;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
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

	public StatusProfissional getStatus() {
		return status;
	}

	public void setStatus(StatusProfissional status) {
		this.status = status;
	}
	
	public Profissional(CargaHorariaDiaria cargaHoraria, String numRegClasse, String nome, int cargo, StatusProfissional status, 
			int turnoTrabalho, boolean isChefe, String siape, boolean isSubchefe, boolean isPlantonista, boolean isUFS) {
	// TODO Auto-generated constructor stub
		this.nome = nome;
		this.numRegClasse = numRegClasse;
		this.cargo = cargo;
		this.status = status;
		this.turnoTrabalho = turnoTrabalho;
		this.cargaHoraria = cargaHoraria;
		this.siape = siape;
		this.isChefe = isChefe;
		this.isSubchefe = isSubchefe;
		this.isPlantonista = isPlantonista;
		this.isUFS = isUFS;
	}
	
	
	public List<SelectItem> getCargoCombo(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem(ENFERMEIRO));
		lista.add(new SelectItem(AUX_ENFERMAGEM));
		lista.add(new SelectItem(TEC_ENFERMAGEM));
		return lista;
	}
	
}
