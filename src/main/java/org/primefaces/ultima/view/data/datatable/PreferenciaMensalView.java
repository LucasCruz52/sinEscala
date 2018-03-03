package org.primefaces.ultima.view.data.datatable;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.ultima.domain.Car;
import org.primefaces.ultima.domain.PreferenciaDiaria;
import org.primefaces.ultima.domain.PreferenciaMensal;
import org.primefaces.ultima.service.CarService;
import org.primefaces.ultima.service.PreferenciaMensalService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean(name="preferenciaDiariaView")
@ViewScoped
public class PreferenciaMensalView {

    private List<PreferenciaDiaria> preferenciasDiariasTodosDias;
    private List<PreferenciaDiaria> preferenciasDiariasDiasNaoUteis;
    private List<PreferenciaDiaria> preferenciasDiariasDiasUteis;

    @ManagedProperty("#{preferenciaMensalService}")
    private PreferenciaMensalService service;

    @PostConstruct
    public void init() {
        preferenciasDiariasTodosDias = service.recuperarPreferenciasDiarias();
        preferenciasDiariasDiasNaoUteis = service.getPreferenciasDiariasNaoUteis();
    }

    public List<PreferenciaDiaria> getPreferenciasDiariasTodosDias() {
        return preferenciasDiariasTodosDias;
    }

    public void setPreferenciasDiariasTodosDias(List<PreferenciaDiaria> preferenciasDiariasTodosDias) {
        this.preferenciasDiariasTodosDias = preferenciasDiariasTodosDias;
    }

    public List<PreferenciaDiaria> getPreferenciasDiariasDiasNaoUteis() {
        return preferenciasDiariasDiasNaoUteis;
    }

    public void setPreferenciasDiariasDiasNaoUteis(List<PreferenciaDiaria> preferenciasDiariasDiasNaoUteis) {
        this.preferenciasDiariasDiasNaoUteis = preferenciasDiariasDiasNaoUteis;
    }

    public List<PreferenciaDiaria> getPreferenciasDiariasDiasUteis() {
        return preferenciasDiariasDiasUteis;
    }

    public void setPreferenciasDiariasDiasUteis(List<PreferenciaDiaria> preferenciasDiariasDiasUteis) {
        this.preferenciasDiariasDiasUteis = preferenciasDiariasDiasUteis;
    }

    public List<PreferenciaDiaria> getPreferenciasMensaisDiasNaoUteis() {
        return preferenciasDiariasDiasNaoUteis;
    }

    public void setPreferenciasMensaisDiasNaoUteis(List<PreferenciaDiaria> preferenciasDiariasDiasNaoUteis) {
        this.preferenciasDiariasDiasNaoUteis = preferenciasDiariasDiasNaoUteis;
    }

    public List<PreferenciaDiaria> getPreferenciasMensaisDiasUteis() {
        return preferenciasDiariasDiasUteis;
    }

    public void setPreferenciasMensaisDiasUteis(List<PreferenciaDiaria> preferenciasDiariasDiasUteis) {
        this.preferenciasDiariasDiasUteis = preferenciasDiariasDiasUteis;
    }

    public void setService(PreferenciaMensalService service) {
        this.service = service;
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Necessidade Modificada", "Antes: " + oldValue + ", Depois:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

}
