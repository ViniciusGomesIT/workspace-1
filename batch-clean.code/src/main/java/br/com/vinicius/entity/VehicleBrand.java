package br.com.vinicius.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbg_vehicle_brand")
public class VehicleBrand {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long idMarcaVeic;

	@Column(name = "NOME", nullable = false)
	private String nome;

	public VehicleBrand(Long idMarcaVeic, String nome) {
		super();
		this.idMarcaVeic = idMarcaVeic;
		this.nome = nome;
	}

	public VehicleBrand() {
		super();
	}

	public Long getIdMarcaVeic() {
		return idMarcaVeic;
	}

	public void setIdMarcaVeic(Long idMarcaVeic) {
		this.idMarcaVeic = idMarcaVeic;
	}

	public String getNome() {
		return nome.toUpperCase();
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMarcaVeic == null) ? 0 : idMarcaVeic.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		VehicleBrand other = (VehicleBrand) obj;
		if (idMarcaVeic == null) {
			if (other.idMarcaVeic != null)
				return false;
		} else if (!idMarcaVeic.equals(other.idMarcaVeic))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
