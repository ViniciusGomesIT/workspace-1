package br.com.vinicius.model;

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
	@Column(name = "id", nullable = true, unique = true)
	private Long id;
	
	@Column(name = "modelo_veic", nullable = true)
	private String modeloVeic;

	@Column(name = "ano_fabricacao", nullable = false)
	private int anoFabricacao;

	@Column(name = "ano_modelo", nullable = false)
	private int anoModelo;

	@Column(name = "cor", nullable = false)
	private String cor;
	
	@JoinColumn(name = "codigo_marca_veic")
	@ManyToOne(cascade = CascadeType.PERSIST)	
	private VehicleBrand marca;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModeloVeic() {
		return modeloVeic;
	}

	public void setModeloVeic(String modeloVeic) {
		this.modeloVeic = modeloVeic;
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
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public VehicleBrand getMarca() {
		return marca;
	}

	public void setMarca(VehicleBrand marca) {
		this.marca = marca;
	}
	
}
