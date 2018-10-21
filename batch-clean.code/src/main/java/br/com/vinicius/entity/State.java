package br.com.vinicius.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component("state")
@Table(name = "tbg_state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long idEstado;

	@Column(name = "ESTADO", nullable = false)
	private String nomeEstado;

	@Column(name = "SIGLA", nullable = false)
	private String sigla;

	public State(Long idEstado, String nomeEstado, String sigla) {
		super();
		this.idEstado = idEstado;
		this.nomeEstado = nomeEstado;
		this.sigla = sigla;
	}

	public State() {
		super();
	}

	public Long getIdEstado() {		
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomeEstado() {
		return nomeEstado.toUpperCase();
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado.toUpperCase();
	}

	public String getSigla() {
		return sigla.toUpperCase();
	}

	public void setSigla(String sigla) {
		this.sigla = sigla.toUpperCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
		result = prime * result + ((nomeEstado == null) ? 0 : nomeEstado.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		if (nomeEstado == null) {
			if (other.nomeEstado != null)
				return false;
		} else if (!nomeEstado.equals(other.nomeEstado))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

}
