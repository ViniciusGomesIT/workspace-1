package br.com.vinicius.service;

import br.com.vinicius.entity.Vehicle;
import br.com.vinicius.repository.VehicleRepository;

public class VehicleService {

	private VehicleRepository repository;

	public VehicleService() {
		this.repository = new VehicleRepository();
	}

	public Vehicle findVehicle(Vehicle vehicle) {
		
		if (null != vehicle.getIdVeic()) {
			return repository.searchVehicleById(vehicle.getIdVeic());
		} else if (null != vehicle.getModeloVeic()){
			return repository.findVehicleByName(vehicle.getModeloVeic().toUpperCase());			
		} else {
			return null;
		}
	}
	
	public Vehicle findVehicleByID(Long id) {
		return repository.searchVehicleById(id);
	}
	
	public String deleteVehicle(Vehicle vehicle) {
		String result = null;
		
		if (null != vehicle.getIdVeic()) {
			result = repository.vehicleDelete(repository.searchVehicleById(vehicle.getIdVeic()));
			return result;
		} else if (null != vehicle.getModeloVeic()) {
			result = repository.vehicleDelete(repository.findVehicleByName(vehicle.getModeloVeic().toUpperCase()));
			return result;
		} else {
			return "Veículo sem informações necessárias para exclusão";
		}
	}
	
	public String vehicleSave(Vehicle vehicle) {		
		
		if (null == vehicle.getMarca().getIdMarcaVeic()) {
			if (null != vehicle.getMarca().getNome()) {
				VehicleBrandService service = new VehicleBrandService();
				
				vehicle.setMarca(service.findVehicleBrandByIdOrName(vehicle.getMarca()));				
			}
		}
		
		return repository.vehicleSave(vehicle);
	}

}
