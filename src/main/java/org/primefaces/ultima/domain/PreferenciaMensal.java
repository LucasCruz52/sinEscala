package org.primefaces.ultima.domain;

import org.primefaces.ultima.service.PreferenciaMensalService;
import org.primefaces.ultima.service.UsuarioService;

import java.util.*;

public class PreferenciaMensal {

    static Integer ultimoId = 1;

    private Integer id;
    private int ano;
    private int mes;
    private UnidadeInternacao unidadeInternacao;
    private int prazoDias;
    private SituacaoEscala situacao;
    private Date dataHoraGeracao;
    private Profissional profissionalGeracao;
    private List<PreferenciaDiaria> preferenciasDiarias;

    public PreferenciaMensal(int ano, int mes, UnidadeInternacao unidadeInternacao, int prazoDias,
                             Profissional profissionalGeracao){
        this.id = ultimoId;
        this.ano = ano;
        this.mes = mes;
        this.unidadeInternacao = unidadeInternacao;
        this.prazoDias = prazoDias;
        this.situacao = new SituacaoEscala();
        this.dataHoraGeracao = new Date();
        this.profissionalGeracao = profissionalGeracao;
        this.preferenciasDiarias = PreferenciaDiaria.gerarPreferenciasDiarias(this.id, ano, mes);

        ultimoId = ultimoId + 1;
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

    public SituacaoEscala getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEscala situacao) {
        this.situacao = situacao;
    }

    public Date getDataHoraGeracao() {
        return dataHoraGeracao;
    }

    public void setDataHoraGeracao(Date dataHoraGeracao) {
        this.dataHoraGeracao = dataHoraGeracao;
    }

    public Profissional getProfissionalGeracao() {
        return profissionalGeracao;
    }

    public void setProfissionalGeracao(Profissional profissionalGeracao) {
        this.profissionalGeracao = profissionalGeracao;
    }

    public List<PreferenciaDiaria> getPreferenciasDiarias() {
        return preferenciasDiarias;
    }

    public void setPreferenciasDiarias(List<PreferenciaDiaria> preferenciasDiarias) {
        this.preferenciasDiarias = preferenciasDiarias;
    }

    public boolean desalocarProfissional(PreferenciaDiaria preferenciaDiariaParaDesalocacao, BlocoHorarioPreferencia blocoHorarioPreferenciaParaDesalocacao, ProfissionalAlocado profissionalParaDesalocacao){

        boolean desalocado = false;

        if(profissionalParaDesalocacao.profissional.cargo == 1){
            if(blocoHorarioPreferenciaParaDesalocacao.enfermeirosAlocados.size() > 0){
                if(blocoHorarioPreferenciaParaDesalocacao.enfermeirosAlocados.remove(profissionalParaDesalocacao)) {
                    desalocado = true;
                }
            }
        }else if(profissionalParaDesalocacao.profissional.cargo == 2){
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


}
