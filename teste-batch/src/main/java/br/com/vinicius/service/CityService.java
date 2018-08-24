package br.com.vinicius.service;

import br.com.vinicius.entity.City;
import br.com.vinicius.repository.CityRepository;

public class CityService {

	private CityRepository repository;

	public CityService() {
		
		this.repository = new CityRepository();
	}
	
	public City findCityByIdOrName(City city) {
		
		if (null != city.getIdCidade()) {
			return repository.findCityById(city.getIdCidade());
		} else if (null != city.getNomeCidade()) {
			return repository.findCityByName(city.getNomeCidade().toUpperCase());
		} else {
			return null;
		}
	}
	
	public String saveCity(City city) {
		
		city.setNomeCidade(city.getNomeCidade().toUpperCase());
				
		String result = repository.saveCity(city);		
		
		return result;
	}	

	public String deleteCity(City city) {
		
		String result = null;
		
		if (null != city.getIdCidade()) {
			result = repository.deleteCity(repository.findCityById(city.getIdCidade()));
			return result;
		} else if (null != city.getNomeCidade()) {
			result = repository.deleteCity(repository.findCityByName(city.getNomeCidade().toUpperCase()));
			return result;
		} else {
			return null;
		}
	}
}
