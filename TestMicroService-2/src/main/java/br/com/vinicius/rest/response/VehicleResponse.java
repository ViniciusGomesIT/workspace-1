package br.com.vinicius.rest.response;

import br.com.vinicius.model.VehicleBrand;

@SuppressWarnings("unused")
public class VehicleResponse {

	private Long id;
	private String modeloVeic;
	private int anoFabricacao;
	private int anoModelo;
	private String cor;
	private VehicleBrand marca;

	public void setId(Long id) {
		this.id = id;
	}

	public void setModeloVeic(String modeloVeic) {
		this.modeloVeic = modeloVeic;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void setMarca(VehicleBrand marca) {
		this.marca = marca;
	}

}
