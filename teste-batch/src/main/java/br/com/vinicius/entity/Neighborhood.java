package br.com.vinicius.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbg_neighborhood")
public class Neighborhood {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long idBairro;

	@Column(name = "BAIRRO")
	private String nomeBairro;

	@JoinColumn(name = "CODIGO_CIDADE")
	@ManyToOne
	private City cidade;

	public Neighborhood(Long idBairro, String nomeBairro, City cidade) {
		super();
		this.idBairro = idBairro;
		this.nomeBairro = nomeBairro;
		this.cidade = cidade;
	}

	public Neighborhood() {
		super();
	}

	public Long getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(Long idBairro) {
		this.idBairro = idBairro;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public City getCidade() {
		return cidade;
	}

	public void setCidade(City cidade) {
		this.cidade = cidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((idBairro == null) ? 0 : idBairro.hashCode());
		result = prime * result + ((nomeBairro == null) ? 0 : nomeBairro.hashCode());
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
		Neighborhood other = (Neighborhood) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (idBairro == null) {
			if (other.idBairro != null)
				return false;
		} else if (!idBairro.equals(other.idBairro))
			return false;
		if (nomeBairro == null) {
			if (other.nomeBairro != null)
				return false;
		} else if (!nomeBairro.equals(other.nomeBairro))
			return false;
		return true;
	}

}
