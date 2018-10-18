package br.com.vinicius.builder;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.rest.response.VehicleBrandResponse;

public class VehicleBrandResponseBuilder {

	private Long id;
	private String description;
	
	public static VehicleBrandResponseBuilder vehicleBrandResponseBuilder() {
		return new VehicleBrandResponseBuilder();
	}
	
	public VehicleBrandResponseBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public VehicleBrandResponseBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	public List<VehicleBrandResponse> convert(List<VehicleBrand> values) {
		return values
				.stream()
				.map(vehicleBrand -> vehicleBrandResponseBuilder()
						.id(vehicleBrand.getId())
						.description(vehicleBrand.getDescription())
						.build())
				.collect(Collectors.toList());
	}
	
	public VehicleBrandResponse convert(VehicleBrand value) {
		return vehicleBrandResponseBuilder()
				.id(value.getId())
				.description(value.getDescription())
				.build();
	} 
	
	public VehicleBrandResponse build() {
		VehicleBrandResponse response = new VehicleBrandResponse();
		
		response.setId(this.id);
		response.setDescription(this.description);
		
		return response;
	}
}
