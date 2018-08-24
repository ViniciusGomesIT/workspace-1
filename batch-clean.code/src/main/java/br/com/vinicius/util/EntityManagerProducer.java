package br.com.vinicius.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {
	
	static EntityManagerFactory emf = null;
	static EntityManager entityManager = null;

	public static EntityManager producer() {
		emf = Persistence.createEntityManagerFactory("connection");
		entityManager = emf.createEntityManager();
		
		return entityManager;
	}
	
	public void entityManagerCloser(EntityManager em) {
		try {
			em.close();	
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao encerrar a conexão" + e.getMessage());
		} finally {
			em.close();
		}			
	}
}
