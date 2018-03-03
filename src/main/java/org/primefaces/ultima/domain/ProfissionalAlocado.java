package org.primefaces.ultima.domain;

public class ProfissionalAlocado {

    protected int id;
    protected Profissional profissional;
    protected boolean presente;

    public ProfissionalAlocado(Profissional profissional, boolean presente) {
        this.profissional = profissional;
        this.presente = presente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Profissional getProfissionalAlocado() {
        return profissional;
    }

    public void setProfissionalAlocado(Profissional profissionalAlocado) {
        this.profissional = profissionalAlocado;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
