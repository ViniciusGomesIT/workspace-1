package br.com.vinicius.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.vinicius.model.VehicleBrand;

public interface VehicleRepository extends JpaRepository<VehicleBrand, Long>{

	@Query("SELECT FROM VehicleBrand")
	List<VehicleBrand> findAllVehicleBrand();
	
	// TODO realocar para o serviço do usuário
//	@Query("SELECT")
//	List<Vehicle> findPersonVehicles(Long id);
}
