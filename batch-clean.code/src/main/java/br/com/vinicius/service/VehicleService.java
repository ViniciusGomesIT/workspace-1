package br.com.vinicius.service;

import br.com.vinicius.entity.Vehicle;

public interface VehicleService {

	Vehicle findVehicle(Vehicle vehicle);

	Vehicle findVehicleByID(Long id);

	void deleteVehicle(Vehicle vehicle);

	void vehicleSave(Vehicle vehicle);

}