package org.primefaces.ultima.service;

import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.ultima.DAO.DiaAnoDAO;
import org.primefaces.ultima.DAO.PreferenciaDiariaDAO;
import org.primefaces.ultima.DAO.PreferenciaMensalDAO;
import org.primefaces.ultima.DAO.UnidadeDAO;
import org.primefaces.ultima.domain.*;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "preferenciaMensalService")
@SessionScoped
public class PreferenciaMensalService {

    private BlocoHorarioPreferencia selectedBlock;
    private List<BlocoHorarioPreferencia> selectedBlocks;
    private int valorInicial = 5;

    private Integer id;
    private int ano;
    private int mes;
    private int idUnidade;
    private int prazoDias;
    private SituacaoEscala situacao;
    private Date dataHoraGeracao;
    private Usuario usuarioGeracao;
    private int idUsuario;
    private List<PreferenciaDiaria> preferenciasDiarias;
    private List<BlocoHorarioPreferencia> blocoHorarioPreferenciaEscolhidos;
    private List<PreferenciaDiaria> preferenciasDiariasNaoUteis;

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public List<BlocoHorarioPreferencia> getBlocoHorarioPreferenciaEscolhidos() {
        return blocoHorarioPreferenciaEscolhidos;
    }

    public void setBlocoHorarioPreferenciaEscolhidos(List<BlocoHorarioPreferencia> blocoHorarioPreferenciaEscolhidos) {
        this.blocoHorarioPreferenciaEscolhidos = blocoHorarioPreferenciaEscolhidos;
    }

    public List<PreferenciaDiaria> getPreferenciasDiariasNaoUteis() {
        PreferenciaMensal preferenciaMensal = new PreferenciaMensal(2018, 2, null, 5, null);
        this.preferenciasDiarias = preferenciaMensal.getPreferenciasDiarias();
        this.preferenciasDiariasNaoUteis = preferenciaMensal.recuperarDiasNaoUteis();
        this.ano = preferenciaMensal.getAno();
        this.mes = preferenciaMensal.getMes();
        return this.preferenciasDiariasNaoUteis;
    }

    public void setPreferenciasDiariasNaoUteis(List<PreferenciaDiaria> preferenciasDiariasNaoUteis) {
        this.preferenciasDiariasNaoUteis = preferenciasDiariasNaoUteis;
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

    public List<PreferenciaDiaria> recuperarPreferenciasDiarias(){
        PreferenciaMensal preferenciaMensal = new PreferenciaMensal(2018, 2, null, 5, null);

        this.preferenciasDiarias = preferenciaMensal.getPreferenciasDiarias();
        this.preferenciasDiariasNaoUteis = preferenciaMensal.recuperarDiasNaoUteis();
        this.ano = preferenciaMensal.getAno();
        this.mes = preferenciaMensal.getMes();

        return this.preferenciasDiarias;
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

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Necessidade Editada", ((BlocoHorarioPreferencia) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada", ((BlocoHorarioPreferencia) event.getObject()).getId().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Necessidade Modificada", "Antiga: " + oldValue + ", Nova:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public String formatarDiaMes(int numero){
        String numeroFormatado;

        if(numero < 10){
            numeroFormatado = "0" + numero;
        }else{
            numeroFormatado = "" + numero;
        }

        return  numeroFormatado;
    }

    public void atualizarValores(){
        if(preferenciasDiariasNaoUteis != null){
            for(int i = 0; i < preferenciasDiariasNaoUteis.size(); i++){
                for(int j = 0; j < preferenciasDiariasNaoUteis.get(i).getBlocosHorarioPreferencia().size(); i++) {
                    preferenciasDiariasNaoUteis.get(i).getBlocosHorarioPreferencia().get(j).setQuantidadeNecessidadeTecnicos(this.valorInicial);
                    preferenciasDiariasNaoUteis.get(i).getBlocosHorarioPreferencia().get(j).setQuantidadeNecessidadeEnfermeiros(this.valorInicial);
                }
            }
        }

        int teste = preferenciasDiariasNaoUteis.get(0).getBlocosHorarioPreferencia().get(0).getQuantidadeNecessidadeEnfermeiros();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "teste", "teste: " + teste);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void gerarListaPreferenciasUnidade(){

        UnidadeInternacao unidade = new UnidadeInternacao();
        unidade.setId(this.idUnidade);

        Usuario usuario = new Usuario();
        usuario.setId(38);

        PreferenciaMensal preferenciaMensal = new PreferenciaMensal(this.ano, this.mes, unidade, 5, usuario);

        PreferenciaMensalDAO preferenciaMensalDAO = new PreferenciaMensalDAO();
        PreferenciaMensal preferenciaMensalSalva = preferenciaMensalDAO.cadastrarPrefenrenciaMensal(preferenciaMensal);

        if(preferenciaMensalSalva != null){

            List<DiasMes> diasMes = new ArrayList<DiasMes>();

            diasMes = DiasMes.recuperarDiasMes(ano, mes);

            List<PreferenciaDiaria> listaPreferenciasDiarias = new ArrayList<PreferenciaDiaria>();

            for(int i = 0; i < diasMes.size(); i++){
                PreferenciaDiaria preferencia = new PreferenciaDiaria(diasMes.get(i).getDia(),diasMes.get(i).getDiaSemana(),diasMes.get(i).getTipo());
                preferencia.setPreferenciaMensal(preferenciaMensalSalva);
                listaPreferenciasDiarias.add(preferencia);
            }

            PreferenciaDiariaDAO preferenciaDiariaDAO = new PreferenciaDiariaDAO();
            List<PreferenciaDiaria> listaPreferenciasSalvas = preferenciaDiariaDAO.cadastrarPrefenrenciasDiarias(listaPreferenciasDiarias);

            if(listaPreferenciasSalvas != null){

                List<BlocoHorarioPreferencia> listaBlocosHorarioPreferencia = new ArrayList<BlocoHorarioPreferencia>();

                List<Turno> turno = new ArrayList<Turno>();

                turno.add(new Turno(new Time(7,0,0), new Time(13,0,0), 1));
                turno.add(new Turno(new Time(13,0,0), new Time(19,0,0), 2));
                turno.add(new Turno(new Time(19,0,0), new Time(7,0,0), 3));


                for (int i = 0; i < listaPreferenciasSalvas.size(); i++) {

                    for (int j = 0; j < turno.size(); j++) {

                        BlocoHorarioPreferencia bloco = new BlocoHorarioPreferencia (turno.get(j).getHrInicio(), turno.get(j).getHrFim(),
                                turno.get(j).getTurno(), 0, 0);

                        bloco.setPreferenciaDiaria(listaPreferenciasDiarias.get(i));
                        listaBlocosHorarioPreferencia.add(bloco);
                    }

                }
                //FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Preferência mensal gerada!","");
                //FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        }else{
            FacesMessage msg = new FacesMessage("Falha na geração da preferência mensal!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
