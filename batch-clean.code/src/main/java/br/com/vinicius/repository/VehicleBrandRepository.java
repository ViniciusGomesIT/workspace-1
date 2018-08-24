package br.com.vinicius.repository;

import java.util.List;

import br.com.vinicius.entity.VehicleBrand;

public interface VehicleBrandRepository {

	VehicleBrand findVehicleBrandById(Long id);

	VehicleBrand findVehicleBrandByName(String name);

	List<VehicleBrand> findAllVehicleBrand();

	void vehicleBrandSave(VehicleBrand marca);

	void deleteVehicleBrand(VehicleBrand marca);

}