package br.com.vinicius.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.repository.VehicleRepository;
import br.com.vinicius.service.VehicleService;

@Component
public class VehicleServiceImpl implements VehicleService {
	
	private VehicleRepository repository;
	
	@Inject
	public VehicleServiceImpl(VehicleRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<VehicleBrand> getAllVehicleBrand() {		
		return repository.findAllVehicleBrand();
	}
	
// TODO realocar para o endpoint de usuário
//	@Override
//	public List<Vehicle> getPersonVehicles() {
//		return repository.findPersonVehicles();
//	}

}
