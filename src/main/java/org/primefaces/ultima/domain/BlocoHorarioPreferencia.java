package org.primefaces.ultima.domain;

import org.primefaces.ultima.DAO.UsuarioDAO;
import org.primefaces.ultima.domain.ExigenciasLegais;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;
import java.util.*;

@Entity
@Table(name = "blocoHorarioPreferencia", schema = "public")
public class BlocoHorarioPreferencia {

    protected Integer id;
    protected Integer idPreferenciaDiaria;
    protected Time horaInicio;
    protected Time horaFim;
    protected int turno;
    protected int quantidadeNecessidadeEnfermeiros;
    protected int quantidadeNecessidadeTecnicos;
    protected List<ProfissionalAlocado> enfermeirosAlocados = new ArrayList<ProfissionalAlocado>();
    protected List<ProfissionalAlocado> tecnicosAlocados = new ArrayList<ProfissionalAlocado>();;

    public BlocoHorarioPreferencia(int idPreferenciaDiaria, Time horaInicio, Time horaFim, int turno, int quantidadeNecessidadeEnferemeiros, int quantidadeNecessidadesTecnicos) {

        this.idPreferenciaDiaria = idPreferenciaDiaria;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.turno = turno;
        this.quantidadeNecessidadeEnfermeiros = quantidadeNecessidadeEnferemeiros;
        this.quantidadeNecessidadeTecnicos = quantidadeNecessidadesTecnicos;

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

    public int getQuantidadeNecessidadeEnfermeiros() {
        return quantidadeNecessidadeEnfermeiros;
    }

    public void setQuantidadeNecessidadeEnfermeiros(int quantidadeNecessidadeEnferemeiros) {
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

        /*

        Profissional profissional = new Profissional(null,"1", "Lucas Mateus de Santana Cruz",null, null, 1,false, "1", false, false, false);
        ProfissionalAlocado profissionalAlocado = new ProfissionalAlocado(profissional, false);

        List<ProfissionalAlocado> profissionaisAlocados = new ArrayList<ProfissionalAlocado>();
        profissionaisAlocados.add(profissionalAlocado);

        for(int j = 0; j < 4; j++){
            ProfissionalAlocado profissionalAlocado2 = new ProfissionalAlocado(null, false);
            profissionaisAlocados.add(profissionalAlocado2);
        }

        */

        for(int i = 0; i < 3; i++){

            BlocoHorarioPreferencia bloco = new BlocoHorarioPreferencia(idPreferenciaDiaria, turno.get(i).getHrInicio(), turno.get(i).getHrFim(),
                    turno.get(i).getTurno(), 0, 0);

            blocosHorarioPreferencia.add(bloco);

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

    public boolean alocarProfissioal(Profissional profissionalParaAlocacao){

        boolean alocado = false;

        //Verificar se a vaga ainda está disponível

        //Verificar exigências legais para alocação
        //if (ExigenciasLegais.atendeExigenciasLegaisPreferencia(this.id, profissionalParaAlocacao.id)) {

            if (profissionalParaAlocacao.getTurnoTrabalho() == 1) {
                //if (this.quantidadeNecessidadeEnfermeiros < this.enfermeirosAlocados.size()) {
                    //this.enfermeirosAlocados = new ArrayList<ProfissionalAlocado>();
                    this.enfermeirosAlocados.add(new ProfissionalAlocado(profissionalParaAlocacao, false));
                    alocado = true;
                //}
            } else if (profissionalParaAlocacao.getTurnoTrabalho() == 2) {
                //if (this.quantidadeNecessidadeTecnicos < this.tecnicosAlocados.size()) {
                    //this.tecnicosAlocados.add(new ProfissionalAlocado(profissionalParaAlocacao, false));
                    alocado = true;
                //}
            }

        //}

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

    public List<ProfissionalAlocado> recuperarTodosProfissionaisBloco(){
        List<ProfissionalAlocado> profissionaisAlocados = new ArrayList<ProfissionalAlocado>();

        if(enfermeirosAlocados != null) {
            for (int i = 0; i < enfermeirosAlocados.size(); i++) {
                profissionaisAlocados.add(enfermeirosAlocados.get(i));
            }
        }

        if(tecnicosAlocados != null) {
            for (int i = 0; i < tecnicosAlocados.size(); i++) {
                profissionaisAlocados.add(tecnicosAlocados.get(i));
            }
        }

        return profissionaisAlocados;
    }

}
