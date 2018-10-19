package br.com.vinicius.builder;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.rest.response.VehicleBrandResponse;

public class VehicleBrandResponseBuilder {

	private Long id;
	private String nome;
	
	public static VehicleBrandResponseBuilder vehicleBrandResponseBuilder() {
		return new VehicleBrandResponseBuilder();
	}
	
	public VehicleBrandResponseBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public VehicleBrandResponseBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public List<VehicleBrandResponse> convert(List<VehicleBrand> values) {
		return values
				.stream()
				.map(vehicleBrand -> vehicleBrandResponseBuilder()
						.id(vehicleBrand.getId())
						.nome(vehicleBrand.getNome())
						.build())
				.collect(Collectors.toList());
	}
	
	public VehicleBrandResponse convert(VehicleBrand value) {
		return vehicleBrandResponseBuilder()
				.id(value.getId())
				.nome(value.getNome())
				.build();
	} 
	
	public VehicleBrandResponse build() {
		VehicleBrandResponse response = new VehicleBrandResponse();
		
		response.setId(this.id);
		response.setNome(this.nome);
		
		return response;
	}
}
