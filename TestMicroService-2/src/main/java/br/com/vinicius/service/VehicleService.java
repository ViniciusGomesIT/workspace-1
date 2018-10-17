package br.com.vinicius.service;

import java.util.List;

import br.com.vinicius.model.Vehicle;
import br.com.vinicius.model.VehicleBrand;

public interface VehicleService {
	
	public List<VehicleBrand> getAllVehicleBrand();
	
	public List<Vehicle> getPersonVehicles();
}
