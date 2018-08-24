package br.com.vinicius.repository;

import br.com.vinicius.entity.Vehicle;

public interface VehicleRepository {

	Vehicle searchVehicleById(Long id);

	Vehicle findVehicleByName(String name);

	void vehicleSave(Vehicle vehicle);

	void vehicleDelete(Vehicle vehicle);

}