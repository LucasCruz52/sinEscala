package org.primefaces.ultima.domain;

import java.util.List;

public class UnidadeInternacao {

    static Integer ultimoId;

    protected Integer id;
    protected String nome;
    protected String descricao;
    protected String sigla;
    protected List<Profissional> profissionais;

    public UnidadeInternacao(String nome, String descricao, String sigla) {
        this.id = ultimoId;
        this.nome = nome;
        this.descricao = descricao;
        this.sigla = sigla;

        ultimoId = ultimoId + 1;
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
