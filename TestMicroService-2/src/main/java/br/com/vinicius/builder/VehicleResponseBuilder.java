package br.com.vinicius.builder;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vinicius.model.Vehicle;
import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.rest.response.VehicleResponse;

public class VehicleResponseBuilder {
	
	private Long id;
	private String modeloVeic;
	private int anoFabricacao;
	private int anoModelo;
	private String cor;
	private VehicleBrand marca;
	
	public static VehicleResponseBuilder vehicleResponseBuilder() {
		return new VehicleResponseBuilder();
	}
	
	public VehicleResponseBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public VehicleResponseBuilder modeloVeic(String modeloVeic) {
		this.modeloVeic = modeloVeic;
		return this;
	}
	
	public VehicleResponseBuilder anoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
		return this;
	}
	
	public VehicleResponseBuilder anoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
		return this;
	}
	
	public VehicleResponseBuilder vehicleBrand(VehicleBrand marca) {
		this.marca = marca;
		return this;
	}
	
	public VehicleResponseBuilder cor(String cor) {
		this.cor = cor;
		return this;
	}
	
	public List<VehicleResponse> convert(List<Vehicle> values) {
		return values
				.stream()
				.map( vehicle -> vehicleResponseBuilder()
						.id(vehicle.getId())
						.modeloVeic(vehicle.getModeloVeic())
						.anoFabricacao(vehicle.getAnoFabricacao())
						.anoModelo(vehicle.getAnoModelo())
						.vehicleBrand(vehicle.getMarca())
						.build() )
				.collect(Collectors.toList());
	}
	
	public VehicleResponse convert(Vehicle value) {
		return vehicleResponseBuilder()
				.id(value.getId())
				.modeloVeic(value.getModeloVeic())
				.anoFabricacao(value.getAnoFabricacao())
				.anoModelo(value.getAnoModelo())
				.vehicleBrand(value.getMarca())
				.build();
	}
	
	public VehicleResponse build() {
		VehicleResponse response = new VehicleResponse();
		
		response.setId(this.id);
		response.setModeloVeic(this.modeloVeic);
		response.setAnoFabricacao(this.anoFabricacao);
		response.setAnoModelo(this.anoModelo);
		response.setCor(this.cor);
		response.setMarca(this.marca);
		
		return response;
	}

}
