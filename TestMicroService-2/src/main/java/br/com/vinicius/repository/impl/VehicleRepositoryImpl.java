package br.com.vinicius.repository.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.vinicius.model.Vehicle;
import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.repository.VehicleRepository;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

	@Override
	public List<VehicleBrand> findAllVehicleBrand() {
		// TODO Adicionar implementação do método
		return null;
	}

	@Override
	public List<Vehicle> findPersonVehicles() {
		// TODO Adicionar implementação do método
		return null;
	}

}
