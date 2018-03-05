/*
 * @author Pablo Lima 
 * 
 * Classe de Dominio que armazena as informacoes referntes ao profissionais de Saude da Divisao 
 * de Enfermagem
 */

package org.primefaces.ultima.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profissional", schema = "public")
public class Profissional implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	int id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "siape")
    private String siape;

	@Column(name = "numRegClasse")
    private String numRegClasse;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    @Column(name = "turnoTrabalho")
    private int turnoTrabalho;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @Column(name = "isChefe")
    private boolean isChefe;

    @Column(name = "isSubchefe")
    private boolean isSubchefe;

    @Column(name = "isPlantonista")
    private boolean isPlantonista;

    @Column(name = "telefone")
    private String telefone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unidadeInternacao_id")
    private UnidadeInternacao unidadeInternacao;

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

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public UnidadeInternacao getUnidadeInternacao() {
        return unidadeInternacao;
    }

    public void setUnidadeInternacao(UnidadeInternacao unidadeInternacao) {
        this.unidadeInternacao = unidadeInternacao;
    }

    public Profissional(){};

	public Profissional(CargaHorariaDiaria cargaHoraria, String numRegClasse, String nome, Cargo cargo, StatusProfissional status,
			int turnoTrabalho, boolean isChefe, String siape, boolean isSubchefe, boolean isPlantonista, boolean isUFS) {
	// TODO Auto-generated constructor stub
		this.nome = nome;
		this.numRegClasse = numRegClasse;
		this.cargo = cargo;
		this.turnoTrabalho = turnoTrabalho;
		this.siape = siape;
		this.isChefe = isChefe;
		this.isSubchefe = isSubchefe;
		this.isPlantonista = isPlantonista;
	}

    public String recuperarDescricaoCargo(int i){

	    String cargo = "Indefinido";

        if(i == 1){
            cargo = "Técnico";
        }else if(i == 2){
            cargo = "Enfermeiro";
        }

        return cargo;
    }

    public String getNomeETurno(){

        return this.nome + " ("+this.recuperarDescricaoCargo(this.turnoTrabalho)+")";
    }

}
