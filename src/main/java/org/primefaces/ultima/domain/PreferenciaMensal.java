package org.primefaces.ultima.domain;

import org.primefaces.ultima.DAO.UnidadeDAO;
import org.primefaces.ultima.service.PreferenciaMensalService;
import org.primefaces.ultima.service.UsuarioService;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name = "preferenciaMensal", schema = "public")
public class PreferenciaMensal implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "ano")
    private int ano;

    @Column(name = "mes")
    private int mes;

    @ManyToOne
    @JoinColumn(name = "unidadeInternacao_id")
    private UnidadeInternacao unidadeInternacao;

    @Column(name = "prazoDias")
    private int prazoDias;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = SituacaoEscala.class)
    private List<SituacaoEscala> situacaoPreferencia = new ArrayList<SituacaoEscala>();

    @Column(name = "dataHoraGeracao")
    private Date dataHoraGeracao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioGeracao;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = PreferenciaDiaria.class, mappedBy = "preferenciaMensal")
    private List<PreferenciaDiaria> preferenciasDiarias = new ArrayList<PreferenciaDiaria>();

    public PreferenciaMensal() {

    }

    public PreferenciaMensal(int ano, int mes, UnidadeInternacao unidadeInternacao, int prazoDias,
                             Usuario usuarioGeracao){
        this.ano = ano;
        this.mes = mes;
        this.unidadeInternacao = unidadeInternacao;
        this.prazoDias = prazoDias;
        this.dataHoraGeracao = new Date();
        this.usuarioGeracao = usuarioGeracao;

        //this.preferenciasDiarias = PreferenciaDiaria.gerarPreferenciasDiarias(this.id, ano, mes);

        //alocarProfissionaisDiasUteis();

    }

    public List<SituacaoEscala> getSituacaoPreferencia() {
        return situacaoPreferencia;
    }

    public void setSituacaoPreferencia(List<SituacaoEscala> situacaoPreferencia) {
        this.situacaoPreferencia = situacaoPreferencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public UnidadeInternacao getUnidadeInternacao() {
        return unidadeInternacao;
    }

    public void setUnidadeInternacao(UnidadeInternacao unidadeInternacao) {
        this.unidadeInternacao = unidadeInternacao;
    }

    public int getPrazoDias() {
        return prazoDias;
    }

    public void setPrazoDias(int prazoDias) {
        this.prazoDias = prazoDias;
    }

    public Date getDataHoraGeracao() {
        return dataHoraGeracao;
    }

    public void setDataHoraGeracao(Date dataHoraGeracao) {
        this.dataHoraGeracao = dataHoraGeracao;
    }

    public Usuario getUsuarioGeracao() {
        return usuarioGeracao;
    }

    public void setUsuarioGeracao(Usuario usuarioGeracao) {
        this.usuarioGeracao = usuarioGeracao;
    }

    public List<PreferenciaDiaria> getPreferenciasDiarias() {
        return preferenciasDiarias;
    }

    public void setPreferenciasDiarias(List<PreferenciaDiaria> preferenciasDiarias) {
        this.preferenciasDiarias = preferenciasDiarias;
    }

    public boolean desalocarProfissional(PreferenciaDiaria preferenciaDiariaParaDesalocacao, BlocoHorarioPreferencia blocoHorarioPreferenciaParaDesalocacao, ProfissionalAlocado profissionalParaDesalocacao){

        boolean desalocado = false;

        if(profissionalParaDesalocacao.profissional.getCargo().getId() == 1){
            if(blocoHorarioPreferenciaParaDesalocacao.enfermeirosAlocados.size() > 0){
                if(blocoHorarioPreferenciaParaDesalocacao.enfermeirosAlocados.remove(profissionalParaDesalocacao)) {
                    desalocado = true;
                }
            }
        }else if(profissionalParaDesalocacao.profissional.getCargo().getId() == 2){
            if(blocoHorarioPreferenciaParaDesalocacao.tecnicosAlocados.size() > 0){
                if(blocoHorarioPreferenciaParaDesalocacao.tecnicosAlocados.remove(profissionalParaDesalocacao)) {
                    desalocado = true;
                }
            }
        }

        if(desalocado){
            //Chamar DAO para salvar bloco de horário de preferência no banco
            //Inserir Registro de Situação do Profissional desalocado no Banco
            //Registrar log de desalocação no Banco
        }

        return desalocado;

    }

    public List<PreferenciaDiaria> recuperarAlocacoesMensaisProfissional(Profissional profissional) {

        List<PreferenciaDiaria> preferenciaDiarias = new ArrayList<PreferenciaDiaria>();

        for(int i = 0; i < this.preferenciasDiarias.size(); i++){

            for(int j = 0; j < this.preferenciasDiarias.get(i).getBlocosHorarioPreferencia().size(); j++){

                List<ProfissionalAlocado> profissionaisAlocados = new ArrayList<ProfissionalAlocado>();

                for(int k = 0; k < profissionaisAlocados.size(); k++) {
                    if (profissional.id == profissionaisAlocados.get(k).id){
                        preferenciaDiarias.add(this.preferenciasDiarias.get(i));
                    }
                }

            }
        }

        return preferenciaDiarias;

    }

    public List<PreferenciaDiaria> recuperarDiasNaoUteis(){
        List<PreferenciaDiaria> preferenciaDiarias = this.preferenciasDiarias;
        List<PreferenciaDiaria> diasNaoUteis = new ArrayList<PreferenciaDiaria>();

        if(preferenciaDiarias != null) {
            for (int i = 0; i < preferenciaDiarias.size(); i++) {
                if(preferenciaDiarias.get(i).getTipo() == 2 || preferenciaDiarias.get(i).getTipo() == 3){
                    diasNaoUteis.add(preferenciaDiarias.get(i));
                }
            }
        }

        return diasNaoUteis;
    }

    private void alocarProfissionaisDiasUteis(){

        List<Profissional> listaProfissionais = new ArrayList<Profissional>();

        //UnidadeDAO unidadeDAO = new UnidadeDAO();
        //listaProfissionais = unidadeDAO.recuperarTodosProfissionaisUnidade();
        listaProfissionais.add(new Profissional(null, "111", "Lucas Mateus de Santana Cruz", null, null,
        1, false, "123", false, false, false));

        for(int i = 0; i < this.getPreferenciasDiarias().size(); i ++){
            for(int j = 0; j < this.getPreferenciasDiarias().get(i).getBlocosHorarioPreferencia().size(); j++){
                for(int k = 0; k < listaProfissionais.size(); k++){
                    if(listaProfissionais.get(k).getTurnoTrabalho() == this.getPreferenciasDiarias().get(i).getBlocosHorarioPreferencia().get(j).getTurno() ) {
                        this.getPreferenciasDiarias().get(i).getBlocosHorarioPreferencia().get(j).alocarProfissioal(listaProfissionais.get(k));
                    }
                }
            }
        }

    }

    /*
    public static void main(String[] args) {

        Locale local = new Locale("pt", "BR");

        PreferenciaMensal preferenciaMensal = new PreferenciaMensal(2018, 1, null, 5, null);

        for(int i = 0; i < preferenciaMensal.preferenciasDiarias.size(); i++) {
            for (int j = 0; j < preferenciaMensal.preferenciasDiarias.get(i).blocosHorarioPreferencia.size(); j++) {
                Calendar calendario = new GregorianCalendar(preferenciaMensal.ano, preferenciaMensal.mes, preferenciaMensal.preferenciasDiarias.get(i).dia);
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).getTipo());
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).getBlocosHorarioPreferencia().get(0).getTecnicosAlocados().get(0).getProfissional().getNome());
                System.out.println(preferenciaMensal.ano);
                //System.out.println(preferenciaMensal.mes);
                System.out.println(calendario.getDisplayName(calendario.MONTH, 1, local));
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).dia);
                System.out.println(calendario.getDisplayName(calendario.DAY_OF_WEEK, 1, local));
                //System.out.println(preferenciaMensal.preferenciasDiarias.get(i).diaSemana);
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).blocosHorarioPreferencia.get(j).turno);
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).blocosHorarioPreferencia.get(j).horaInicio);
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).blocosHorarioPreferencia.get(j).horaFim);
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).blocosHorarioPreferencia.get(j).quantidadeNecessidadeEnfermeiros);
                System.out.println(preferenciaMensal.preferenciasDiarias.get(i).blocosHorarioPreferencia.get(j).quantidadeNecessidadeTecnicos);
            }
        }

    }
    */

    public static void main(String[] args) {
        Timestamp hora = new Timestamp(7);
        System.out.println(hora);
    }


}
