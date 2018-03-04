package org.primefaces.ultima.service;

import org.primefaces.ultima.DAO.VinculoDAO;
import org.primefaces.ultima.domain.Vinculo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vinculoService")
@SessionScoped
public class VinculoService {

    List<Vinculo> listaVinculos = new ArrayList<Vinculo>();

    public List<Vinculo> recuperarVinculos(){
        VinculoDAO perfilDao = new VinculoDAO();
        this.listaVinculos = perfilDao.recuperarVinculos();
        return this.listaVinculos;
    }

}
