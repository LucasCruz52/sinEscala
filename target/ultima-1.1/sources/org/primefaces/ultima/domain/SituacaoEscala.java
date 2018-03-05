/*
 * @author Pablo Lima
 * Classe de domínio que define os status de uma escala
 * Por boas práticas, todas as operações em uma escala devem ser feitas utilizando o nome das variáveis
 * e não o seu conteúdo.
 */

package org.primefaces.ultima.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "situacaoEscala", schema = "public")
public class SituacaoEscala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "dataHora")
	private Timestamp dataHora;

	@ManyToOne
	@JoinColumn(name = "tipoSituacao_id")
	private TipoSituacaoEscala tipoSituacaoEscala;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioRegistro;

	@Column(name = "observacoes")
	private String observacoes;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public TipoSituacaoEscala getTipoSituacaoEscala() {
		return tipoSituacaoEscala;
	}

	public void setTipoSituacaoEscala(TipoSituacaoEscala tipoSituacaoEscala) {
		this.tipoSituacaoEscala = tipoSituacaoEscala;
	}

	public Usuario getUsuarioRegistro() {
		return usuarioRegistro;
	}

	public void setUsuarioRegistro(Usuario usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public SituacaoEscala() {
		// TODO Auto-generated constructor stub
	}
	
}
