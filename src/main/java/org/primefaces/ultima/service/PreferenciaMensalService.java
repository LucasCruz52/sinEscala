package org.primefaces.ultima.service;

import org.primefaces.ultima.domain.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "preferenciaMensalService")
@SessionScoped
public class PreferenciaMensalService {

    private BlocoHorarioPreferencia selectedBlock;
    private List<BlocoHorarioPreferencia> selectedBlocks;

    private Integer id;
    private int ano;
    private int mes;
    private UnidadeInternacao unidadeInternacao;
    private int prazoDias;
    private SituacaoEscala situacao;
    private Date dataHoraGeracao;
    private Profissional profissionalGeracao;
    private List<PreferenciaDiaria> preferenciasDiarias;
    private List<BlocoHorarioPreferencia> blocoHorarioPreferenciaEscolhidos;

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

    public List<PreferenciaDiaria> recuperarPreferenciasDiarias(){
        PreferenciaMensal preferenciaMensal = new PreferenciaMensal(2018, 2, null, 5, null);

        this.preferenciasDiarias = preferenciaMensal.getPreferenciasDiarias();
        this.ano = preferenciaMensal.getAno();
        this.mes = preferenciaMensal.getMes();

        return preferenciaMensal.getPreferenciasDiarias();
    }

    public BlocoHorarioPreferencia getSelectedBlock() {
        return selectedBlock;
    }

    public void setSelectedCar(BlocoHorarioPreferencia selectedBlock) {
        this.selectedBlock = selectedBlock;
    }

    public List<BlocoHorarioPreferencia> getSelectedBlocks() {

        return selectedBlocks;

    }

    public void setSelectedCars(List<BlocoHorarioPreferencia> selectedBlocks) {

        this.selectedBlocks = selectedBlocks;

    }
}
