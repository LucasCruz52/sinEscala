package org.primefaces.ultima.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "restricao", schema = "public")
public class Restricao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "horasTrabalho")
    private int horasTrabalho;

    @Column(name = "horasFOlga")
    private int horasFolga;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "sigla")
    private String sigla;

    public Restricao(){

    }
}
