package br.com.vinicius.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.entity.Vehicle;
import br.com.vinicius.repository.VehicleRepository;
import br.com.vinicius.service.VehicleBrandService;
import br.com.vinicius.service.VehicleService;

@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository repository;
	
	private static final String STRING_FIELD_EMPTY = "";
	private static final Long LONG_FIELD_EMPTY = 0L;

	@Override
	public Vehicle findVehicle(Vehicle vehicle) {
		checkAndBreakIfNameAndIdIsNull(vehicle);
		
		Optional<Long> idVehicle = Optional.ofNullable(vehicle.getIdVeic());
		
		if (idVehicle.isPresent()) {
			return repository.searchVehicleById(vehicle.getIdVeic());
		} else {
			return repository.findVehicleByName(vehicle.getModeloVeic());			
		} 
	}

	@Override
	public Vehicle findVehicleByID(Long id) {
		return repository.searchVehicleById(id);
	}
	
	@Override
	public void deleteVehicle(Vehicle vehicle) {
		checkAndBreakIfNameAndIdIsNull(vehicle);
		
		Optional<Long> idVehicle = Optional.ofNullable(vehicle.getIdVeic());
		
		if (idVehicle.isPresent()) {
			repository.vehicleDelete(repository.searchVehicleById(vehicle.getIdVeic()));
		} else {
			repository.vehicleDelete(repository.findVehicleByName(vehicle.getModeloVeic()));
		} 
	}
	
	@Override
	public void vehicleSave(Vehicle vehicle) {	
		checkAndBreakIfNameAndIdIsNull(vehicle);		
		
		if (LONG_FIELD_EMPTY == vehicle.getMarca().getIdMarcaVeic() 
				|| !STRING_FIELD_EMPTY.equals(vehicle.getMarca().getNome().trim())) {
			
			VehicleBrandService service = new VehicleBrandServiceImpl();
			
			vehicle.setMarca(service.findVehicleBrandByIdOrName(vehicle.getMarca()));
		}
	
		repository.vehicleSave(vehicle);
	}

	
	private void checkAndBreakIfNameAndIdIsNull(Vehicle vehicle) {
		if (null == vehicle.getIdVeic() && STRING_FIELD_EMPTY.equals(vehicle.getModeloVeic().trim())) {
			throw new IllegalArgumentException("Não foi informado o ID nem NOME do veículo");
		}
	}
}
