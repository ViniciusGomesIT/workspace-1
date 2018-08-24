package br.com.vinicius.service;

import br.com.vinicius.entity.City;

public interface CityService {

	City findCityByIdOrName(City city);

	void saveCity(City city);

	void deleteCity(City city);

	void checkAndBreakIfFieldNull(City city);

}