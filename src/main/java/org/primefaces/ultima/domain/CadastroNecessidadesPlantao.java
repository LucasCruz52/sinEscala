/*@author Pablo Lima
 * Classe de dominio do Cadastro das Necessidades de plantao.
 */
package org.primefaces.ultima.domain;



import java.util.Date;

import javax.persistence.Id;

public class CadastroNecessidadesPlantao {

	@Id
	public int id;
	
	public Usuario usuario;
	
	public Unidade unidade;
	
	public Date dataNecessidade;
	
	public Date dataAbertura;
	
	public Date dataFechamento;
	
	public CargaHorariaDiaria cargaHorariaPlantao;
	
	public int quantidadeNecessidade;
	
	public Profissional profissional;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Unidade getUnidade() {
		return unidade;
	}
	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	public Date getDataNecessidade() {
		return dataNecessidade;
	}
	public void setDataNecessidade(Date dataNecessidade) {
		this.dataNecessidade = dataNecessidade;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public CargaHorariaDiaria getCargaHorariaPlantao() {
		return cargaHorariaPlantao;
	}
	public void setCargaHorariaPlantao(CargaHorariaDiaria cargaHorariaPlantao) {
		this.cargaHorariaPlantao = cargaHorariaPlantao;
	}
	public int getQuantidadeNecessidade() {
		return quantidadeNecessidade;
	}
	public void setQuantidadeNecessidade(int quantidadeNecessidade) {
		this.quantidadeNecessidade = quantidadeNecessidade;
	}
	public Profissional getProfissional() {
		return profissional;
	}
	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
	public CadastroNecessidadesPlantao() {
		
	}
	public void validar() {
		
	}
	
	public void cadastrar() {
		
	}

    public static class ProfissionalAlocado {

        static Integer ultimoId = 1;

        protected Integer id;
        protected Profissional profissional;
        protected boolean presente;

        public ProfissionalAlocado(Profissional profissional, boolean presente) {
            this.id = ultimoId;
            this.profissional = profissional;
            this.presente = presente;

            ultimoId = ultimoId +1;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Profissional getProfissional() {
            return profissional;
        }

        public void setProfissional(Profissional profissional) {
            this.profissional = profissional;
        }

        public boolean isPresente() {
            return presente;
        }

        public void setPresente(boolean presente) {
            this.presente = presente;
        }
    }
}
