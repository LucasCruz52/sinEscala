package org.primefaces.ultima.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "intervalo", schema = "public")
public class Intervalo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "turno")
    private int turno;

    @Column(name = "duracao")
    private int duracao;

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Intervalo(){

    };

}
