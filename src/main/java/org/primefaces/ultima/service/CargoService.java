package org.primefaces.ultima.service;

import org.primefaces.ultima.DAO.CargoDAO;
import org.primefaces.ultima.DAO.PerfilDAO;
import org.primefaces.ultima.domain.Car;
import org.primefaces.ultima.domain.Cargo;
import org.primefaces.ultima.domain.Perfil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "cargoService")
@SessionScoped
public class CargoService {

    List<Cargo> listaCargos = new ArrayList<Cargo>();

    public List<Cargo> recuperarCargos(){
        CargoDAO perfilDao = new CargoDAO();
        this.listaCargos = perfilDao.recuperarCargos();
        return this.listaCargos;
    }
}
