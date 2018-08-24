package br.com.vinicius.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.repository.NeighborhoodRepository;
import br.com.vinicius.util.EntityManagerProducer;

@Repository("neighborhoodRepository")
public class NeighborhoodRepositoryImpl implements NeighborhoodRepository {

	private EntityManager em;
	private static final Neighborhood INSTANCE = new Neighborhood();

	public NeighborhoodRepositoryImpl() {		
		this.em = EntityManagerProducer.producer();
	}
	
	@Override
	@Transactional
	public Neighborhood findNeighborhoodById(Long id) {
		try {
			return em.find(Neighborhood.class, id);
			
		} catch (NoResultException e) {
			return INSTANCE;
		}
	}

	@Override
	@Transactional
	public Neighborhood findNeighborhoodByName(String nomeBairro) {		
		try {
			String query = "FROM Neighborhood WHERE nomeBairro = :bairroPessoa";
			
			return em.createQuery(query, Neighborhood.class)
				     .setParameter("bairroPessoa", nomeBairro.toUpperCase())
				     .getSingleResult();		
			
		} catch (NoResultException e) {
			return INSTANCE;
		}
	}
	
	@Override
	@Transactional
	public void saveNeighborhood(Neighborhood neighborhood) {		
		em.getTransaction().begin();
		em.persist(neighborhood);
		em.getTransaction().commit();
		
		System.out.println("Bairro " + neighborhood.getNomeBairro() + " inserido com sucesso!");
	}
	
	@Override
	@Transactional
	public void deleteNeighborhood(Neighborhood neighborhood) {		
		em.getTransaction().begin();
		em.remove(neighborhood);
		em.getTransaction().commit();
		em.flush();
		
		System.out.println("Bairro excluído com sucesso!");
	}
}
