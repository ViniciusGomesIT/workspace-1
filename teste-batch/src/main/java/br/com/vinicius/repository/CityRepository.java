package br.com.vinicius.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import br.com.vinicius.entity.City;
import br.com.vinicius.util.EntityManagerProducer;

public class CityRepository {

	private EntityManager em;

	public CityRepository() {
		this.em = EntityManagerProducer.producer();
	}

	@Transactional
	public City findCityById(Long id) {		
		return em.find(City.class, id);
	}
	
	@Transactional
	public City findCityByName(String name) {		
		try {
			String query = "FROM City WHERE nomeCidade = :cityName";
			
			return em.createQuery(query, City.class)
					 .setParameter("cityName", name.toUpperCase())
					 .getSingleResult();

		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public String saveCity(City city) {
		city.setNomeCidade(city.getNomeCidade().toUpperCase());

		em.getTransaction().begin();
		em.persist(city);
		em.getTransaction().commit();

		return "Cidade " + city.getNomeCidade() + " cadastrada com sucesso!";
	}
	
	@Transactional
	public String deleteCity(City city) {		
		em.getTransaction().begin();
		em.remove(city);
		em.flush();
		em.getTransaction().commit();
		
		return "Cidade " + city.getNomeCidade() + " excluída com sucesso!";
	}
}
