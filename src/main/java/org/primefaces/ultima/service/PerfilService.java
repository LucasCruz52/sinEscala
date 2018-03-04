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

    public List<Perfil> recuperarPerfis(){
        PerfilDAO perfilDao = new PerfilDAO();
        this.listaPerfis = perfilDao.recuperarPerfis();
        return this.listaPerfis;
    }
}
