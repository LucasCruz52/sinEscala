package org.primefaces.ultima.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "unidadeInternacao", schema = "public")
public class UnidadeInternacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "descricao")
    protected String descricao;

    @Column(name = "sigla")
    protected String sigla;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unidadeInternacao")
    protected List<Profissional> profissionais;

    public UnidadeInternacao(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public List<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(List<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    public UnidadeInternacao(String nome, String descricao, String sigla) {
        this.nome = nome;
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public UnidadeInternacao(String nome, String descricao, String sigla, List<Profissional> profissionais) {
        this.nome = nome;
        this.descricao = descricao;
        this.sigla = sigla;
        this.profissionais = profissionais;
    }

    public boolean adicionarProfissonal(Profissional profissional){

        for (int i = 0; i <profissionais.size(); i++) {
            if(profissionais.get(i).id == profissional.id) {
                return false;
            };
        }

        return this.profissionais.add(profissional);
    }

    public boolean removerProfissonal(Profissional profissional){

        for (int i = 0; i <profissionais.size(); i++) {
            if(profissionais.get(i).id == profissional.id) {
                return this.profissionais.remove(profissional);
            };
        }

        return false;
    }
}
