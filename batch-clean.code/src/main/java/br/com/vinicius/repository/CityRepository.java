package br.com.vinicius.repository;

import br.com.vinicius.entity.City;

public interface CityRepository {

	City findCityById(Long id);

	City findCityByName(String name);

	void saveCity(City city);

	void deleteCity(City city);

}