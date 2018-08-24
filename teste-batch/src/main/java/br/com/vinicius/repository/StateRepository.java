package br.com.vinicius.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.vinicius.entity.State;
import br.com.vinicius.util.EntityManagerProducer;

public class StateRepository {

	private EntityManager em;

	@SuppressWarnings("static-access")
	public StateRepository() {		
		this.em = new EntityManagerProducer().producer();
	}

	@Transactional
	public State findStateByName(String nome) {		
		try {
			return em.createQuery("from State WHERE nomeEstado = :stateName", State.class)
					 .setParameter("stateName", nome.toUpperCase())
					 .getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public State findStateByInitials(String initials) {		
		try {
			return em.createQuery("FROM State WHERE SIGLA = :stateInitials", State.class)
					 .setParameter("stateInitials", initials.toUpperCase())
					 .getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}
	
	@Transactional
	public State findStateById(Long id) {		
		return em.find(State.class, id);
	}

	@Transactional
	public String stateSave(State state) {		
		state.setNomeEstado(state.getNomeEstado().toUpperCase());

		em.getTransaction().begin();
		em.persist(state); 
		em.getTransaction().commit();

		return "Estado " + state.getNomeEstado() + " salvo com sucesso";
	}
	
	@Transactional
	public String deleteState(State state) {		
		em.getTransaction().begin();
		em.remove(state);
		em.flush();
		em.getTransaction().commit();
		
		return "Marca " + state.getNomeEstado() + " excluído com sucesso!";
	}
}
