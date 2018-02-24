package data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "usuario", schema = "public", catalog = "postgres")
public class UsuarioEntity {
    private int id;
    private String login;
    private String senha;
    private String nome;
    private String email;
    private int idperfil;
    private Boolean ativo;
    private Date datacadastro;
    private Date dataexpiracao;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "senha")
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "idperfil")
    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    @Basic
    @Column(name = "ativo")
    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Basic
    @Column(name = "datacadastro")
    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    @Basic
    @Column(name = "dataexpiracao")
    public Date getDataexpiracao() {
        return dataexpiracao;
    }

    public void setDataexpiracao(Date dataexpiracao) {
        this.dataexpiracao = dataexpiracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioEntity that = (UsuarioEntity) o;

        if (id != that.id) return false;
        if (idperfil != that.idperfil) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (senha != null ? !senha.equals(that.senha) : that.senha != null) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (ativo != null ? !ativo.equals(that.ativo) : that.ativo != null) return false;
        if (datacadastro != null ? !datacadastro.equals(that.datacadastro) : that.datacadastro != null) return false;
        if (dataexpiracao != null ? !dataexpiracao.equals(that.dataexpiracao) : that.dataexpiracao != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + idperfil;
        result = 31 * result + (ativo != null ? ativo.hashCode() : 0);
        result = 31 * result + (datacadastro != null ? datacadastro.hashCode() : 0);
        result = 31 * result + (dataexpiracao != null ? dataexpiracao.hashCode() : 0);
        return result;
    }
}
