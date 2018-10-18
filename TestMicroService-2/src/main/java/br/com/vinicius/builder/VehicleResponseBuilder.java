package br.com.vinicius.builder;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vinicius.model.Vehicle;
import br.com.vinicius.rest.response.VehicleResponse;

public class VehicleResponseBuilder {
	
	private Long id;
	private String description;
	
	public static VehicleResponseBuilder vehicleResponseBuilder() {
		return new VehicleResponseBuilder();
	}
	
	public VehicleResponseBuilder id(Long id) {
		this.id = id;
		return this;
	}
	
	public VehicleResponseBuilder description(String description) {
		this.description = description;
		return this;
	}
	
	public List<VehicleResponse> convert(List<Vehicle> values) {
		return values
				.stream()
				.map( vehicle -> vehicleResponseBuilder()
						.id(vehicle.getId())
						.description(vehicle.getDescription())
						.build() )
				.collect(Collectors.toList());
	}
	
	public VehicleResponse convert(Vehicle value) {
		return vehicleResponseBuilder()
				.id(value.getId())
				.description(value.getDescription())
				.build();
	}
	
	public VehicleResponse build() {
		VehicleResponse response = new VehicleResponse();
		
		response.setId(this.id);
		response.setDescription(this.description);
		
		return response;
	}

}
