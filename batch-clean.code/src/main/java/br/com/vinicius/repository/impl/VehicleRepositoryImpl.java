package br.com.vinicius.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.vinicius.entity.Vehicle;
import br.com.vinicius.repository.VehicleRepository;
import br.com.vinicius.util.EntityManagerProducer;

@Repository("vehicleRepository")
public class VehicleRepositoryImpl implements VehicleRepository {

	private EntityManager em;
	private static final Vehicle INSTANCE = new Vehicle();

	public VehicleRepositoryImpl() {		
		em = EntityManagerProducer.producer();
	}

	@Override
	@Transactional
	public Vehicle searchVehicleById(Long id) {		
		return em.find(Vehicle.class, id);
	}
	
	@Override
	@Transactional()
	public Vehicle findVehicleByName(String name) {		
		try {
			String query = "FROM Vehicle WHERE modeloVeic = :veic";
			
			return em.createQuery(query, Vehicle.class)
					 .setParameter("veic", name.toUpperCase())
					 .setMaxResults(1)
					 .getSingleResult();
			
		} catch (NoResultException e) {
			return INSTANCE;
		}
	}

	@Override
	@Transactional
	public void vehicleSave(Vehicle vehicle) {
		
		em.getTransaction().begin();
		em.merge(vehicle);
		em.getTransaction().commit();

		System.out.println("Veículo " + vehicle.getModeloVeic() + " salvo com sucesso.");
	}

	@Override
	@Transactional
	public void vehicleDelete(Vehicle vehicle) {
		
		em.getTransaction().begin();
		em.remove(vehicle);
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("Veículo excluído com sucesso");
	}
}
