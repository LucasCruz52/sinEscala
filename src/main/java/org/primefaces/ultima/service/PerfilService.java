package org.primefaces.ultima.service;


import org.primefaces.ultima.DAO.PerfilDAO;
import org.primefaces.ultima.domain.Perfil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "perfilService")
@SessionScoped
public class PerfilService {

    List<Perfil> listaPerfis = new ArrayList<Perfil>();

    Perfil perfilCadasto;

    public List<Perfil> getListaPerfis() {
        return listaPerfis;
    }

    public void setListaPerfis(List<Perfil> listaPerfis) {
        this.listaPerfis = listaPerfis;
    }

    public Perfil getPerfilCadasto() {
        return perfilCadasto;
    }

    public void setPerfilCadasto(Perfil perfilCadasto) {
        this.perfilCadasto = perfilCadasto;
    }

    public List<Perfil> recuperarPerfis(){
        PerfilDAO perfilDao = new PerfilDAO();
        this.listaPerfis = perfilDao.recuperarPerfis();
        return this.listaPerfis;
    }


}
