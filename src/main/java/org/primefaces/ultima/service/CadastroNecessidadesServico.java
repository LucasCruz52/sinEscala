package org.primefaces.ultima.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "cadastroNecessidades")
@ApplicationScoped
public class CadastroNecessidadesServico {
	
	private Collection<Calendar> dataNecessidade = new ArrayList<Calendar>(12);
	
	private Date hoje;
	private int mes;
	
	public CadastroNecessidadesServico() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Collection<Calendar> getDataNecessidade() {
		dataNecessidade.add(Calendar.getInstance());
		return dataNecessidade;
	}


	public void setDataNecessidade(List<Calendar> dataNecessidade) {
		this.dataNecessidade = dataNecessidade;
	}


	public Date getHoje() {
		return new Date();
	}

	public void setDataHoje(Date hoje) {
		this.hoje = hoje;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	public void Cadastrar() {
		
	}
}
