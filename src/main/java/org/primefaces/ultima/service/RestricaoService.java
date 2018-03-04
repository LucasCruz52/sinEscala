package org.primefaces.ultima.service;

import org.primefaces.ultima.DAO.PerfilDAO;
import org.primefaces.ultima.DAO.RestricaoDAO;
import org.primefaces.ultima.domain.Perfil;
import org.primefaces.ultima.domain.Restricao;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "restricaoService")
@SessionScoped
public class RestricaoService {

    List<Restricao> listaRestricoes;

    public List<Restricao> recuperarRestricoes(){
        RestricaoDAO restricaoDAO = new RestricaoDAO();
        this.listaRestricoes = restricaoDAO.recuperarRestricoes();
        return this.listaRestricoes;
    }
}
