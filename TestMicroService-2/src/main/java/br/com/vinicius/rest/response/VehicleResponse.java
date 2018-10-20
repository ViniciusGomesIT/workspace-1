package br.com.vinicius.rest.response;

import br.com.vinicius.model.VehicleBrand;

public class VehicleResponse {

	private Long id;
	private String modeloVeic;
	private int anoFabricacao;
	private int anoModelo;
	private String cor;
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
