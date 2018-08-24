package br.com.vinicius.service;

import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.repository.VehicleBrandRepository;

public class VehicleBrandService {

	private VehicleBrandRepository repository;

	public VehicleBrandService() {		
		this.repository = new VehicleBrandRepository();
	}

	public VehicleBrand findVehicleBrandByIdOrName(VehicleBrand brand) {		
		if (null != brand.getIdMarcaVeic()) {
			return repository.findVehicleBrandById(brand.getIdMarcaVeic());
		} else if(null != brand.getNome()) {
			return repository.findVehicleBrandByName(brand.getNome().toUpperCase());
		} else {
			return null;
		}
	}

	public String VehicleBrandSave(VehicleBrand brand) {		
		brand.setNome(brand.getNome().toUpperCase());

		String result = repository.vehicleBrandSave(brand);

		return result;
	}

	public String deleteVehicleBrand(VehicleBrand brand) {
		
		String result = null;
		
		if (null != brand.getIdMarcaVeic()) {
			result = repository.deleteVehicleBrand(repository.findVehicleBrandById(brand.getIdMarcaVeic()));
			return result;
		} else if (null != brand.getNome()) {
			result = repository.deleteVehicleBrand(repository.findVehicleBrandByName(brand.getNome().toUpperCase()));
			return result;
		} else {
			return "Sem informações necessárias para exclusão.";
		}
	}
}
