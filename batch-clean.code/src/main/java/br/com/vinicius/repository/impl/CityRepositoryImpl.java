package br.com.vinicius.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.vinicius.entity.City;
import br.com.vinicius.repository.CityRepository;
import br.com.vinicius.util.EntityManagerProducer;

@Repository("cityRepository")
public class CityRepositoryImpl implements CityRepository {

	private EntityManager em;
	private static final City INSTANCE = new City();

	public CityRepositoryImpl() {
		this.em = EntityManagerProducer.producer();		
	}

	@Override
	@Transactional
	public City findCityById(Long id) {		
		return em.find(City.class, id);
	}
	
	@Override
	@Transactional
	public City findCityByName(String name) {		
		try {
			String query = "FROM City WHERE nomeCidade = :cityName";
			
			return em.createQuery(query, City.class)
					 .setParameter("cityName", name.toUpperCase())
					 .getSingleResult();

		} catch (NoResultException e) {
			return INSTANCE;
		}
	}

	/* (non-Javadoc)
	 * @see br.com.vinicius.repository.CityRepository#saveCity(br.com.vinicius.entity.City)
	 */
	@Override
	@Transactional
	public void saveCity(City city) {
		city.setNomeCidade(city.getNomeCidade().toUpperCase());

		em.getTransaction().begin();
		em.persist(city);
		em.getTransaction().commit();

		System.out.println("Cidade " + city.getNomeCidade() + " cadastrada com sucesso!");
	}
	
	/* (non-Javadoc)
	 * @see br.com.vinicius.repository.CityRepository#deleteCity(br.com.vinicius.entity.City)
	 */
	@Override
	@Transactional
	public void deleteCity(City city) {		
		em.getTransaction().begin();
		em.remove(city);
		em.flush();
		em.getTransaction().commit();

		System.out.println("Cidade excluída com sucesso!");
	}
}
