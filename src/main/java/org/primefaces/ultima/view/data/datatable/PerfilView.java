package org.primefaces.ultima.view.data.datatable;

import org.primefaces.ultima.domain.Perfil;
import org.primefaces.ultima.service.PerfilService;
import org.primefaces.ultima.service.UsuarioService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="perfilView")
@ViewScoped
public class PerfilView {

    List<Perfil> perfisEncontrados = new ArrayList<Perfil>();

    @ManagedProperty("#{perfilService}")
    private PerfilService service;

    @PostConstruct
    public void init() {
        this.perfisEncontrados = service.recuperarPerfis();
    }

    public List<Perfil> getPerfisEncontrados() {
        return perfisEncontrados;
    }

    public PerfilService getService() {
        return service;
    }

    public void setService(PerfilService service) {
        this.service = service;
    }

    public void setPerfisEncontrados(List<Perfil> perfisEncontrados) {
        this.perfisEncontrados = perfisEncontrados;
    }
}
