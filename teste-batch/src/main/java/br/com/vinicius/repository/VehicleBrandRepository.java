package br.com.vinicius.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.util.EntityManagerProducer;

public class VehicleBrandRepository {

	private EntityManager em;

	public VehicleBrandRepository() {		
		em = EntityManagerProducer.producer();
	}

	@Transactional
	public VehicleBrand findVehicleBrandById(Long id) {		
		VehicleBrand marcaResult = em.find(VehicleBrand.class, id);
		
		return marcaResult;
	}
	
	@Transactional
	public VehicleBrand findVehicleBrandByName(String name) {		
		try {
			String query = "FROM VehicleBrand WHERE nome LIKE :brandName";
			
			return em.createQuery(query, VehicleBrand.class)
					 .setParameter("brandName", "%" + name.toUpperCase() + "%")
					 .setMaxResults(1)
					 .getSingleResult();
			
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<VehicleBrand> findAllVehicleBrand() {		
		List<VehicleBrand> lista = em.createQuery("FROM VehicleBrand").getResultList();

		return lista;
	}

	@Transactional
	public String vehicleBrandSave(VehicleBrand marca) {
		
		marca.setNome(marca.getNome()
				           .toUpperCase());

		em.getTransaction().begin();
		em.merge(marca);
		em.getTransaction().commit();

		return "Marca " + marca.getNome() + " inserida com sucesso!";
	}

	@Transactional
	public String deleteVehicleBrand(VehicleBrand marca) {
		
		em.getTransaction().begin();
		em.remove(marca);
		em.flush();
		em.getTransaction().commit();
		
		return "Marca " + marca.getNome() + " removida com sucesso!";
	}
}
