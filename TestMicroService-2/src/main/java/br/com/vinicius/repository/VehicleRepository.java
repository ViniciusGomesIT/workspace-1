package br.com.vinicius.repository;

import java.util.List;

import br.com.vinicius.model.Vehicle;
import br.com.vinicius.model.VehicleBrand;

//TODO adicionar extends JPARpository
public interface VehicleRepository  {

	List<VehicleBrand> findAllVehicleBrand();
	
	List<Vehicle> findPersonVehicles();
}
