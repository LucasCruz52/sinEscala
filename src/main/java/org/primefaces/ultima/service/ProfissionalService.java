package org.primefaces.ultima.service;

import org.primefaces.ultima.domain.Cargo;
import org.primefaces.ultima.domain.Perfil;
import org.primefaces.ultima.domain.Profissional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "profissionalService")
@SessionScoped
public class ProfissionalService {

    Profissional profissionalCadastro;

    Cargo cargo = new Cargo();

    Perfil perfil = new Perfil();

    public Profissional getProfissionalCadastro() {
        return profissionalCadastro;
    }

    public void setProfissionalCadastro(Profissional profissionalCadastro) {
        this.profissionalCadastro = profissionalCadastro;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
