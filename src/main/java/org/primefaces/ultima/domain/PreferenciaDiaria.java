package org.primefaces.ultima.domain;

import java.util.ArrayList;
import java.util.List;

public class PreferenciaDiaria {

    static Integer ultimoId = 1;

    protected Integer id;
    protected Integer idPreferenciaMensal;
    protected int dia;
    protected int diaSemana;
    private int tipo;
    protected List<BlocoHorarioPreferencia> blocosHorarioPreferencia;

    public PreferenciaDiaria(Integer idPreferenciaMensal, int dia, int diaSemana, int tipo) {
        this.id = ultimoId;
        this.idPreferenciaMensal = idPreferenciaMensal;
        this.dia = dia;
        this.diaSemana = diaSemana;
        this.tipo = tipo;
        this.blocosHorarioPreferencia = BlocoHorarioPreferencia.gerarBlocosHorarioPreferencia(this.id);

        ultimoId = ultimoId + 1;
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
            preferenciaDiarias.add(new PreferenciaDiaria(idPreferenciaMensal, diasMes.get(i).getDia(),diasMes.get(i).getDiaSemana(),diasMes.get(0).getTipo()));
        }

        return preferenciaDiarias;
    }

}
