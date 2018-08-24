package br.com.vinicius.service;

import java.util.List;

import br.com.vinicius.entity.VehicleBrand;

public interface VehicleBrandService {

	VehicleBrand findVehicleBrandByIdOrName(VehicleBrand brand);

	void VehicleBrandSave(VehicleBrand brand);

	void deleteVehicleBrand(VehicleBrand brand);
	
	List<VehicleBrand> findAll();

}