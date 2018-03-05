package org.primefaces.ultima.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "preferenciaDiaria", schema = "public")
public class PreferenciaDiaria {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    protected Integer id;

    @Column(name = "dia")
    protected int dia;

    @Column(name = "diaSemana")
    protected int diaSemana;

    @Column(name = "tipo")
    private int tipo;

    @ManyToOne
    @JoinColumn(name = "preferenciaMensal_id")
    protected PreferenciaMensal preferenciaMensal;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = BlocoHorarioPreferencia.class, mappedBy = "preferenciaMensal")
    protected List<BlocoHorarioPreferencia> blocosHorarioPreferencia;

    public PreferenciaDiaria(int dia, int diaSemana, int tipo) {
        this.dia = dia;
        this.diaSemana = diaSemana;
        this.tipo = tipo;
        this.blocosHorarioPreferencia = BlocoHorarioPreferencia.gerarBlocosHorarioPreferencia(this.id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<BlocoHorarioPreferencia> getBlocosHorarioPreferencia() {

        return blocosHorarioPreferencia;
    }

    public void setBlocosHorarioPreferencia(List<BlocoHorarioPreferencia> blocosHorarioPreferencia) {
        this.blocosHorarioPreferencia = blocosHorarioPreferencia;
    }

    static public List<PreferenciaDiaria> gerarPreferenciasDiarias(Integer idPreferenciaMensal, int ano, int mes){

        List<DiasMes> diasMes = new ArrayList<DiasMes>();

        diasMes = DiasMes.recuperarDiasMes(ano, mes);

        List<PreferenciaDiaria> preferenciaDiarias = new ArrayList<PreferenciaDiaria>();

        for(int i = 0; i < diasMes.size(); i++){
            preferenciaDiarias.add(new PreferenciaDiaria(idPreferenciaMensal, diasMes.get(i).getDia(),diasMes.get(i).getDiaSemana(),diasMes.get(i).getTipo()));
        }

        return preferenciaDiarias;
    }

}
