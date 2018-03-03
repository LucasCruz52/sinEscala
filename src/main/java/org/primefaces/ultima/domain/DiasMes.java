package org.primefaces.ultima.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class DiasMes {

    private int dia;
    private int diaSemana;
    //Tipo 1 -> dia de trabalho, Tipo 2 -> Feriado...
    private int tipo;

    public DiasMes(int dia, int diaSemana, int tipo) {
        this.dia = dia;
        this.diaSemana = diaSemana;
        this.tipo = tipo;
    }

    static public List<DiasMes> recuperarDiasMes(int ano, int mes){

        int dia = 1;

        List<DiasMes> diasMes = new ArrayList<DiasMes>();

        // Create a calendar object and set year and month
        Calendar calendario = new GregorianCalendar(ano, mes, dia);

        // Get the number of days in that month
        int quantidadeDiasMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);

        for(int i = 0; i < quantidadeDiasMes; i++){
            diasMes.add(new DiasMes(calendario.get(5),calendario.get(7),1));
            dia++;
            calendario = new GregorianCalendar(ano, mes, dia);
        }

        return diasMes;

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
}

