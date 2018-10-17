package br.com.vinicius.rest.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vinicius.model.Vehicle;

public class VehicleResponse {
	
	private Long id;
	private String description;
	
	public VehicleResponse(Long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<VehicleResponse> convert(List<VehicleResponse> values) {
		return values
				.stream()
				.map(vehicle -> new VehicleResponse(vehicle.id, vehicle.getDescription()))
				.collect(Collectors.toList());
	}
	
	public VehicleResponse convert(Vehicle value) {
		return new VehicleResponse(value.getId(), value.getDescription());
	}
}
