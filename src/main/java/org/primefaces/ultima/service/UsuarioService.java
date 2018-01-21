package org.primefaces.ultima.service;

import java.util.*;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import org.primefaces.ultima.domain.Car;
import org.primefaces.ultima.domain.Perfil;
import org.primefaces.ultima.domain.Usuario;

@ManagedBean(name = "usuarioService")
@ApplicationScoped
public class UsuarioService {

    private final static String[] nome;

    private final static String[] login;

    private final static String[] senha;

    private final static String[] email;

    private final static Date[] dataExpiracao;

    private final static String[] ativo;

    static {

        nome = new String[10];
        nome[0] = "Lucas Mateus de Santana Cruz";
        nome[1] = "Allan Silva Santos";
        nome[2] = "Pablo Lima";
        nome[3] = "João José";
        nome[4] = "Maria Cristina";

        login = new String[10];
        login[0] = "lucas.cruz";
        login[1] = "allan.silva";
        login[2] = "pablo.lima";
        login[3] = "joao.jose";
        login[4] = "maria.cristina";

        senha = new String[10];
        senha[0] = "senha1";
        senha[1] = "senha2";
        senha[2] = "senha3";
        senha[3] = "senha4";
        senha[4] = "senha5";

        email = new String[10];
        email[0] = "lucas.cruz@gmail.com";
        email[1] = "allan.silva@gmail.com";
        email[2] = "pablo.lima@gmail.com";
        email[3] = "joao.jose@gmail.com";
        email[4] = "maria.cristina@gmail.com";

        dataExpiracao = new Date[10];
        dataExpiracao[0] = new Date();
        dataExpiracao[1] = new Date();
        dataExpiracao[2] = new Date();
        dataExpiracao[3] = new Date();
        dataExpiracao[4] = new Date();

        ativo = new String[2];
        ativo[0] = "Ativo";
        ativo[1] = "Inativo";

    }

    public List<Usuario> createUsuarios(int size) {
        List<Usuario> list = new ArrayList<Usuario>();
        for(int i = 0 ; i < size ; i++) {
            list.add(new Usuario(getRandomId(), getRandomLogin(), getRandomSenha(), getRandomNome(), getRandomEmail(), null, getRandomDataExpiracao()));
        }

        return list;
    }

    private int getRandomId() {
        return (int)(Math.random() * 50 + 1960);
    }

    private String getRandomNome() {
        return nome[(int) (Math.random() * 5)];
    }

    private String getRandomLogin() {
        return login[(int) (Math.random() * 5)];
    }

    private String getRandomSenha() {
        return senha[(int) (Math.random() * 5)];
    }

    private String getRandomEmail() {
        return email[(int) (Math.random() * 5)];
    }

    private Date getRandomDataExpiracao() {
        return dataExpiracao[(int) (Math.random() * 5)];
    }

    private String getRandomAtivo() {
        return ativo[(int) (Math.random() * 2)];
    }

    public List<String> getNomes() {
        return Arrays.asList(nome);
    }

    public List<String> getLogins() {
        return Arrays.asList(login);
    }

    public List<String> getSenhas() {
        return Arrays.asList(senha);
    }

    public List<String> getEmails() {
        return Arrays.asList(email);
    }

    public List<Date> getDatasExpiracao() {
        return Arrays.asList(dataExpiracao);
    }

    public List<String> getAtivos() {
        return Arrays.asList(ativo);
    }

}
