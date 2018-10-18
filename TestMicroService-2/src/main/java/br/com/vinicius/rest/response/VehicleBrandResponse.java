package br.com.vinicius.rest.response;

import java.util.List;
import java.util.stream.Collectors;

import br.com.vinicius.model.VehicleBrand;

public class VehicleBrandResponse {
	
	//TODO implementar padrão build e alterar o controller;
	
	private Long id;
	private String description;
	
	public VehicleBrandResponse(Long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public VehicleBrandResponse() {

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
	
	public List<VehicleBrandResponse> convert(List<VehicleBrand> values) {
		return values
				.stream()
				.map(vehicleBrand -> new VehicleBrandResponse(vehicleBrand.getId(), vehicleBrand.getDescription()))
				.collect(Collectors.toList());
	}
	
	public VehicleBrandResponse convert(VehicleBrand value) {
		return new VehicleBrandResponse(value.getId(), value.getDescription());
	}
}
