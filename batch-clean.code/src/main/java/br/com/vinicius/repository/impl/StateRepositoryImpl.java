package br.com.vinicius.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.vinicius.entity.State;
import br.com.vinicius.repository.StateRepository;
import br.com.vinicius.util.EntityManagerProducer;

@Repository("stateRepository")
public class StateRepositoryImpl implements StateRepository {

	private EntityManager em;
	private static final State INSTANCE = new State();

	@SuppressWarnings("static-access")
	public StateRepositoryImpl() {		
		this.em = new EntityManagerProducer().producer();
	}

	@Override
	@Transactional
	public State findStateByName(String nome) {		
		try {
			return em.createQuery("from State WHERE nomeEstado = :stateName", State.class)
					 .setParameter("stateName", nome.toUpperCase())
					 .getSingleResult();
		} catch (NoResultException e) {
			return INSTANCE;
		}
	}

	@Override
	@Transactional
	public State findStateByInitials(String initials) {		
		try {
			return em.createQuery("FROM State WHERE SIGLA = :stateInitials", State.class)
					 .setParameter("stateInitials", initials.toUpperCase())
					 .getSingleResult();

		} catch (NoResultException e) {
			return INSTANCE;
		}
	}
	
	@Override
	@Transactional
	public State findStateById(Long id) {		
		return em.find(State.class, id);
	}

	@Override
	@Transactional
	public void stateSave(State state) {		
		state.setNomeEstado(state.getNomeEstado().toUpperCase());

		em.getTransaction().begin();
		em.persist(state); 
		em.getTransaction().commit();
		
		System.out.println("Estado " + state.getNomeEstado() + " salvo com sucesso");
	}
	
	@Override
	@Transactional
	public void deleteState(State state) {		
		em.getTransaction().begin();
		em.remove(state);
		em.flush();
		em.getTransaction().commit();
		
		System.out.println("Estado excluído com sucesso!");		
	}
}