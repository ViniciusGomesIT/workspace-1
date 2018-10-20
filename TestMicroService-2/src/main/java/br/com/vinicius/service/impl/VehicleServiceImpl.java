package br.com.vinicius.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.repository.VehicleRepository;
import br.com.vinicius.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	private VehicleRepository repository;
	
	@Inject
	public VehicleServiceImpl(VehicleRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<VehicleBrand> getAllVehicleBrand() {		
		return repository.findAll();
	}
	
// TODO realocar para o endpoint de usuário
//	@Override
//	public List<Vehicle> getPersonVehicles() {
//		return repository.findPersonVehicles();
//	}

}
