package br.com.vinicius.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.vinicius.model.Vehicle;
import br.com.vinicius.model.VehicleBrand;

public interface VehicleResource {
	
	ResponseEntity<List<VehicleBrand>> getAllVehicleBrand();

	ResponseEntity<List<Vehicle>> getPersonVehicle();
}
