package br.com.vinicius.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbg_vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long idVeic;

	@Column(name = "MODELO_VEIC", nullable = false)
	private String modeloVeic;

	@Column(name = "ANO_FABRICACAO", nullable = false)
	private int anoFabricacao;

	@Column(name = "ANO_MODELO", nullable = false)
	private int anoModelo;

	@Column(name = "COR", nullable = false)
	private String cor;

	@JoinColumn(name = "CODIGO_MARCA_VEIC")
	@ManyToOne(cascade = CascadeType.PERSIST)	
	private VehicleBrand marca;

	public Vehicle(Long idVeic, String modeloVeic, int anoFabricacao, int anoModelo, String cor, VehicleBrand marca) {
		super();
		this.idVeic = idVeic;
		this.modeloVeic = modeloVeic;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.cor = cor;
		this.marca = marca;
	}

	public Vehicle() {
		super();
	}
	
	public Long getIdVeic() {		
		return idVeic;
	}
	
	public void setIdVeic(Long idVeic) {
		this.idVeic = idVeic;
	}

	public String getModeloVeic() {
		return modeloVeic.toUpperCase();
	}

	public void setModeloVeic(String modeloVeic) {
		this.modeloVeic = modeloVeic.toUpperCase();
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getCor() {
		return cor.toUpperCase();
	}

	public void setCor(String cor) {
		this.cor = cor.toUpperCase();
	}

	public VehicleBrand getMarca() {
		return marca;
	}

	public void setMarca(VehicleBrand marca) {
		this.marca = marca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoFabricacao;
		result = prime * result + anoModelo;
		result = prime * result + ((cor == null) ? 0 : cor.hashCode());
		result = prime * result + ((idVeic == null) ? 0 : idVeic.hashCode());
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((modeloVeic == null) ? 0 : modeloVeic.hashCode());
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
		Vehicle other = (Vehicle) obj;
		if (anoFabricacao != other.anoFabricacao)
			return false;
		if (anoModelo != other.anoModelo)
			return false;
		if (cor == null) {
			if (other.cor != null)
				return false;
		} else if (!cor.equals(other.cor))
			return false;
		if (idVeic == null) {
			if (other.idVeic != null)
				return false;
		} else if (!idVeic.equals(other.idVeic))
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (modeloVeic == null) {
			if (other.modeloVeic != null)
				return false;
		} else if (!modeloVeic.equals(other.modeloVeic))
			return false;
		return true;
	}

}
