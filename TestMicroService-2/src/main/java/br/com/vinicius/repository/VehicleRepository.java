package br.com.vinicius.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vinicius.model.VehicleBrand;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleBrand, Long> {

	// TODO realocar para o serviço do usuário
//	@Query("SELECT")
//	List<Vehicle> findPersonVehicles(Long id);
}
