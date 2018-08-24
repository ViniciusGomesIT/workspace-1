package br.com.vinicius.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.repository.VehicleBrandRepository;
import br.com.vinicius.util.EntityManagerProducer;

@Repository("vehicleBrandRepository")
public class VehicleBrandRepositoryImpl implements VehicleBrandRepository {

	private EntityManager em;
	private static final VehicleBrand INSTANCE = new VehicleBrand();

	public VehicleBrandRepositoryImpl() {		
		em = EntityManagerProducer.producer();
	}

	@Override
	@Transactional
	public VehicleBrand findVehicleBrandById(Long id) {	
		
		return em.find(VehicleBrand.class, id);
	}
	
	@Override
	@Transactional
	public VehicleBrand findVehicleBrandByName(String name) {		
		try {
			String query = "FROM VehicleBrand WHERE nome LIKE :brandName";
			
			return em.createQuery(query, VehicleBrand.class)
					 .setParameter("brandName", "%" + name.toUpperCase() + "%")
					 .setMaxResults(1)
					 .getSingleResult();
			
		} catch (NoResultException e) {
			return INSTANCE;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional
	public List<VehicleBrand> findAllVehicleBrand() {		

		return em.createQuery("FROM VehicleBrand").getResultList();
	}

	@Override
	@Transactional
	public void vehicleBrandSave(VehicleBrand marca) {		

		em.getTransaction().begin();
		em.merge(marca);
		em.getTransaction().commit();

		System.out.println("Marca " + marca.getNome() + " inserida com sucesso!");
	}

	@Override
	@Transactional
	public void deleteVehicleBrand(VehicleBrand marca) {
		
		em.getTransaction().begin();
		em.remove(marca);
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("Marca excluída com sucesso!");
	}
}
