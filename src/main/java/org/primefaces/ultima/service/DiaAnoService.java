package org.primefaces.ultima.service;

import org.primefaces.ultima.DAO.DiaAnoDAO;
import org.primefaces.ultima.domain.DiaAno;
import org.primefaces.ultima.domain.DiasMes;
import org.primefaces.ultima.domain.Perfil;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Calendar;
import java.util.Date;

@ManagedBean(name = "diaAnoService")
@SessionScoped
public class DiaAnoService {

    int tipo;

    Date dataDate = new Date();

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void cadastrar() {

        if(tipo != 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(this.dataDate);

            DiaAno obj = new DiaAno();

            obj.setDia(cal.get(5));
            obj.setMes(cal.get(2));
            obj.setAno(cal.get(1));
            obj.setTipo(tipo);

            DiaAnoDAO diaAnoDao = new DiaAnoDAO();
            DiaAno diaAnoSalvo = diaAnoDao.cadastrarDiaAno(obj);

            if (diaAnoSalvo != null) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Feriado cadastrado com sucesso!", "");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            } else {
                FacesMessage msg = new FacesMessage("Falha no cadastro do feriado!");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }

    }

}
