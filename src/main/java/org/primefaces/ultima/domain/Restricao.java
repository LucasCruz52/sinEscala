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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHorasTrabalho() {
        return horasTrabalho;
    }

    public void setHorasTrabalho(int horasTrabalho) {
        this.horasTrabalho = horasTrabalho;
    }

    public int getHorasFolga() {
        return horasFolga;
    }

    public void setHorasFolga(int horasFolga) {
        this.horasFolga = horasFolga;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
