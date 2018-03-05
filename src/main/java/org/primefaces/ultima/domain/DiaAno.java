package org.primefaces.ultima.domain;

import sun.security.util.BigInt;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "diaAno", schema = "public")
public class DiaAno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "ano")
    private int ano;

    @Column(name = "mes")
    private int mes;

    @Column(name = "dia")
    private int dia;

    @Column(name = "tipo")
    private int tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
