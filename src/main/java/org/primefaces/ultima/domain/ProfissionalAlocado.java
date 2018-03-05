package org.primefaces.ultima.domain;

import javax.persistence.*;

@Entity
@Table(name = "profissionalAlocado", schema = "public")
public class ProfissionalAlocado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    protected Profissional profissional;

    @Column(name = "presente")
    protected boolean presente;

    public ProfissionalAlocado() {

    }

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
