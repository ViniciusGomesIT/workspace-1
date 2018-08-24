package br.com.vinicius.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import br.com.vinicius.entity.City;
import br.com.vinicius.repository.CityRepository;
import br.com.vinicius.service.CityService;

@Service("cityService")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CityServiceImpl implements CityService {
	
	@Value("${dbUsername}")
	private String userName;
	
	@Value("${dbPassword}")
	private String password;
	
	@Value("${filePath}")
	private String url;

	@Autowired
	private CityRepository repository;

	private static final String STRING_FIELD_EMPTY = "";
	private static final Long LONG_FIELD_EMPTY = 0L;

	public CityServiceImpl() {
		
	}

	@Override
	public City findCityByIdOrName(City city) {
		checkAndBreakIfFieldNull(city);

		Optional<Long> idCity = Optional.ofNullable(city.getIdCidade());

		if (idCity.isPresent()) {
			return repository.findCityById(city.getIdCidade());
		} else {
			return repository.findCityByName(city.getNomeCidade().toUpperCase());
		}
	}

	@Override
	public void saveCity(City city) {

		repository.saveCity(city);
	}

	@Override
	public void deleteCity(City city) {
		checkAndBreakIfFieldNull(city);

		Optional<Long> idCity = Optional.ofNullable(city.getIdCidade());

		if (idCity.isPresent()) {
			repository.deleteCity(repository.findCityById(city.getIdCidade()));
		} else {
			repository.deleteCity(repository.findCityByName(city.getNomeCidade()));
		}
	}

	@Override
	public void checkAndBreakIfFieldNull(City city) {
		if (LONG_FIELD_EMPTY == city.getIdCidade() && STRING_FIELD_EMPTY.equals(city.getNomeCidade().trim())) {
			throw new IllegalArgumentException("Não foi informado o ID nem o NOME da cidade");
		}
	}

	public void print() {
		System.out.println("User: " + userName);
		System.out.println("Pass: " + password);
		System.out.println("Url: " + url);
	}
}
