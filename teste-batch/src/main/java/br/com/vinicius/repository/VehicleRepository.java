package br.com.vinicius.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.vinicius.entity.Vehicle;
import br.com.vinicius.util.EntityManagerProducer;

public class VehicleRepository {

	private EntityManager em;

	public VehicleRepository() {		
		em = EntityManagerProducer.producer();
	}

	@Transactional
	public Vehicle searchVehicleById(Long id) {		
		return em.find(Vehicle.class, id);
	}
	
	@Transactional()
	public Vehicle findVehicleByName(String name) {		
		try {
			String query = "FROM Vehicle WHERE modeloVeic = :veic";
			
			return em.createQuery(query, Vehicle.class)
					 .setParameter("veic", name.toUpperCase())
					 .setMaxResults(1)
					 .getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public String vehicleSave(Vehicle vehicle) {
		vehicle.setModeloVeic(vehicle.getModeloVeic().toUpperCase());
		
		em.getTransaction().begin();
		em.merge(vehicle);
		em.getTransaction().commit();

		return "Veículo " + vehicle.getModeloVeic() + " salvo com sucesso.";
	}

	@Transactional
	public String vehicleDelete(Vehicle vehicle) {
		
		em.getTransaction().begin();
		em.remove(em.find(Vehicle.class, vehicle.getIdVeic()));
		em.flush();
		em.getTransaction().commit();
		
		return "Veículo " + vehicle.getModeloVeic() + " apagado com sucesso";

	}
}
