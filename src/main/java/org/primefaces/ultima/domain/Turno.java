package org.primefaces.ultima.domain;

import java.sql.Time;
import java.util.Date;

public class Turno {

    static Integer ultimoId = 1;

    private Integer id;
    private Time horaInicio;
    private Time horaFim;
    private int Turno;

    public Turno(Time hrInicio, Time hrFim, int turno) {
        this.id = ultimoId;
        this.horaInicio = hrInicio;
        this.horaFim = hrFim;
        Turno = turno;

        ultimoId = ultimoId + 1;
    }

    public Time getHrInicio() {
        return horaInicio;
    }

    public void setHrInicio(Time hrInicio) {
        this.horaInicio = hrInicio;
    }

    public Time getHrFim() {
        return horaFim;
    }

    public void setHrFim(Time hrFim) {
        this.horaFim = hrFim;
    }

    public int getTurno() {
        return Turno;
    }

    public void setTurno(int turno) {
        Turno = turno;
    }

}
