package org.primefaces.ultima.domain;

import org.primefaces.ultima.domain.Perfil;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlSchema;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;
    @Column(name = "login")
    public String login;
    public String senha;
    @Column(name = "nome")
    public String nome;
    public String email;
    @Column(name = "idperfil")
    public int idperfil;
    @Column(name = "ativo")
    public boolean ativo;
    public Date dataCadastro;
    public Date dataExpiracao;

    public Usuario(){}

    public Usuario(String login, String senha, String nome, String email, Perfil perfil, Date dataExpiracao) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.idperfil = 1;
        this.ativo = true;
        this.dataExpiracao = dataExpiracao;
    }

    public Usuario(Integer id, String login, String senha, String nome, String email, Perfil perfil, boolean ativo, Date dataExpiracao) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.idperfil = 1;
        this.ativo = ativo;
        this.dataExpiracao = dataExpiracao;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPerfil() {
        return 1;
    }

    public void setPerfil(Perfil perfil) {
        this.idperfil = 1;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void ativar(){
        this.ativo = true;
    }

    public void desativar(){
        this.ativo = false;
    }

}
