package org.primefaces.ultima.domain;

import org.primefaces.ultima.domain.ExigenciasLegais;

import java.sql.Time;
import java.util.*;

public class BlocoHorarioPreferencia {

    static Integer ultimoId = 1;

    protected Integer id;
    protected Integer idPreferenciaDiaria;
    protected Time horaInicio;
    protected Time horaFim;
    protected int turno;
    protected int quantidadeNecessidadeEnfermeiros;
    protected int quantidadeNecessidadeTecnicos;
    protected List<ProfissionalAlocado> enfermeirosAlocados;
    protected List<ProfissionalAlocado> tecnicosAlocados;

    public BlocoHorarioPreferencia(int idPreferenciaDiaria, Time horaInicio, Time horaFim, int turno, int quantidadeNecessidadeEnferemeiros, int quantidadeNecessidadesTecnicos) {

        this.id = ultimoId;
        this.idPreferenciaDiaria = idPreferenciaDiaria;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.turno = turno;
        this.quantidadeNecessidadeEnfermeiros = quantidadeNecessidadeEnferemeiros;
        this.quantidadeNecessidadeTecnicos = quantidadeNecessidadesTecnicos;

        ultimoId = ultimoId + 1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(Integer ultimoId) {
        BlocoHorarioPreferencia.ultimoId = ultimoId;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getQuantidadeNecessidadeEnferemeiros() {
        return quantidadeNecessidadeEnfermeiros;
    }

    public void setQuantidadeNecessidadeEnferemeiros(int quantidadeNecessidadeEnferemeiros) {
        this.quantidadeNecessidadeEnfermeiros = quantidadeNecessidadeEnferemeiros;
    }

    public int getQuantidadeNecessidadeTecnicos() {
        return quantidadeNecessidadeTecnicos;
    }

    public void setQuantidadeNecessidadeTecnicos(int quantidadeNecessidadeTecnicos) {
        this.quantidadeNecessidadeTecnicos = quantidadeNecessidadeTecnicos;
    }

    public List<ProfissionalAlocado> getEnfermeirosAlocados() {
        return enfermeirosAlocados;
    }

    public void setEnfermeirosAlocados(List<ProfissionalAlocado> enfermeirosAlocados) {
        this.enfermeirosAlocados = enfermeirosAlocados;
    }

    public List<ProfissionalAlocado> getTecnicosAlocados() {
        return tecnicosAlocados;
    }

    public void setTecnicosAlocados(List<ProfissionalAlocado> tecnicosAlocados) {
        this.tecnicosAlocados = tecnicosAlocados;
    }

    public static List<BlocoHorarioPreferencia> gerarBlocosHorarioPreferencia(Integer idPreferenciaDiaria) {

        List<Turno> turno = new ArrayList<Turno>();

        turno.add(new Turno(new Time(7,0,0), new Time(13,0,0), 1));
        turno.add(new Turno(new Time(13,0,0), new Time(19,0,0), 2));
        turno.add(new Turno(new Time(19,0,0), new Time(7,0,0), 3));

        List<BlocoHorarioPreferencia> blocosHorarioPreferencia = new ArrayList<BlocoHorarioPreferencia>();

        for(int i = 0; i < 3; i++){
            blocosHorarioPreferencia.add(new BlocoHorarioPreferencia(idPreferenciaDiaria, turno.get(i).getHrInicio(), turno.get(i).getHrFim(),
                    turno.get(i).getTurno(), 0, 0));
        }

        return blocosHorarioPreferencia;
    }

    public boolean editarNecessidadeEnfermeiros(int novaNecessidadeEnfermeiros){

        boolean modificado = false;

        //Chamar DAO para verificar se a lista de preferências ainda não foi disponibilizada

        if(novaNecessidadeEnfermeiros > this.enfermeirosAlocados.size()){
            this.quantidadeNecessidadeEnfermeiros = novaNecessidadeEnfermeiros;
            modificado = true;
        }

        if(modificado){
            //Chamar DAO para salvar bloco de horário de preferência no banco
            //Registrar log de modificação no Banco
        }

        return modificado;
    }

    public boolean editarNecessidadeTecnicos(int novaNecessidadeTecnicos){

        boolean modificado = false;

        //Chamar DAO para verificar se a lista de preferências ainda não foi disponibilizada

        if(novaNecessidadeTecnicos > this.tecnicosAlocados.size()){
            this.quantidadeNecessidadeTecnicos = novaNecessidadeTecnicos;
            modificado = true;
        }

        if(modificado){
            //Chamar DAO para salvar bloco de horário de preferência no banco
            //Registrar log de modificação no Banco
        }

        return modificado;
    }

    public boolean EnfermeiroAlocado(Profissional enfermeiro){

        boolean encontrado = false;

        for(int i = 0; i < this.enfermeirosAlocados.size(); i++){
            if(enfermeiro.id == this.enfermeirosAlocados.get(i).profissional.id){
                encontrado = true;
            }
        }

        return encontrado;

    }

    public boolean TecnicoAlocado(Profissional tecnico){

        boolean encontrado = false;

        for(int i = 0; i < this.enfermeirosAlocados.size(); i++){
            if(tecnico.id == this.enfermeirosAlocados.get(i).profissional.id){
                encontrado = true;
            }
        }

        return encontrado;

    }

    public boolean alocarProfissioal(BlocoHorarioPreferencia blocoHorarioPreferenciaParaAlocacao, Profissional profissionalParaAlocacao){

        boolean alocado = false;

        //Verificar se a vaga ainda está disponível

        //Verificar exigências legais para alocação
        if (ExigenciasLegais.atendeExigenciasLegaisPreferencia(this.id, profissionalParaAlocacao.id)) {

            if (profissionalParaAlocacao.cargo == 1) {
                if (blocoHorarioPreferenciaParaAlocacao.quantidadeNecessidadeEnfermeiros < blocoHorarioPreferenciaParaAlocacao.enfermeirosAlocados.size()) {
                    blocoHorarioPreferenciaParaAlocacao.enfermeirosAlocados.add(new ProfissionalAlocado(profissionalParaAlocacao, false));
                    alocado = true;
                }
            } else if (profissionalParaAlocacao.cargo == 2) {
                if (blocoHorarioPreferenciaParaAlocacao.quantidadeNecessidadeTecnicos < blocoHorarioPreferenciaParaAlocacao.tecnicosAlocados.size()) {
                    blocoHorarioPreferenciaParaAlocacao.tecnicosAlocados.add(new ProfissionalAlocado(profissionalParaAlocacao, false));
                    alocado = true;
                }
            }

        }

        if(alocado) {
            //Chamar DAO para salvar bloco de horário de preferência no banco
            //Inserir Registro de Situação do Profissional Alocado no Banco
            //Registrar log de alocação no Banco
        }

        return alocado;
    }

    public String recuperarDescricaoTurnos(int i){
        String turno;

        if(i == 1){
            turno = "Manhã";
        }else if(i == 2){
            turno = "Tarde";
        }else if(i == 3){
            turno = "Noite";
        }else{
            turno = "";
        }

        return turno;
    }

    public String formatarHorarioExibicao(String horario){

        if(horario.length() == 8){
            horario = horario.substring(0,5);
        }

        return horario;
    }

}
