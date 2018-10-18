package br.com.vinicius.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.vinicius.model.Vehicle;
import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.repository.impl.VehicleRepositoryImpl;
import br.com.vinicius.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	@Inject
	VehicleRepositoryImpl repository;

	@Override
	public List<VehicleBrand> getAllVehicleBrand() {		
		return repository.findAllVehicleBrand();
	}

	@Override
	public List<Vehicle> getPersonVehicles() {
		return repository.findPersonVehicles();
	}

}
