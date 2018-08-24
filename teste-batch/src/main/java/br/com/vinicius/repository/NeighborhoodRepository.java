package br.com.vinicius.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.util.EntityManagerProducer;

public class NeighborhoodRepository {

	private EntityManager em;

	public NeighborhoodRepository() {		
		this.em = EntityManagerProducer.producer();
	}
	
	@Transactional
	public Neighborhood findNeighborhoodById(Long id) {
		try {
			return em.find(Neighborhood.class, id);
			
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public Neighborhood findNeighborhoodByName(String nomeBairro) {
		
		try {
			String query = "FROM Neighborhood WHERE nomeBairro = :bairroPessoa";
			
			return em.createQuery(query, Neighborhood.class)
				     .setParameter("bairroPessoa", nomeBairro.toUpperCase())
				     .getSingleResult();		
			
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional
	public String saveNeighborhood(Neighborhood neighborhood) {		
		neighborhood.setNomeBairro(neighborhood.getNomeBairro().toUpperCase());
		
		em.getTransaction().begin();
		em.persist(neighborhood);
		em.getTransaction().commit();
		
		return "Bairro " + neighborhood.getNomeBairro() + " inserido com sucesso!";
	}
	
	@Transactional
	public String deleteNeighborhood(Neighborhood neighborhood) {		
		em.getTransaction().begin();
		em.remove(neighborhood);
		em.getTransaction().commit();
		em.flush();
		
		return "Bairro " + neighborhood.getNomeBairro() + " excluído com sucesso!";
		
	}
}
