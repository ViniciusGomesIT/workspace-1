package br.com.vinicius.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.entity.City;
import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.entity.Person;
import br.com.vinicius.entity.State;
import br.com.vinicius.entity.Vehicle;
import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.repository.PersonRepository;
import br.com.vinicius.service.CityService;
import br.com.vinicius.service.NeighborhoodService;
import br.com.vinicius.service.PersonService;
import br.com.vinicius.service.StateService;
import br.com.vinicius.service.VehicleBrandService;
import br.com.vinicius.service.VehicleService;

@Service("personService")
public class PersonServiceImpl implements PersonService {

	private PersonRepository repository;
	private CityService cityService;
	private StateService stateService;
	private NeighborhoodService neighborhoodService;
	private VehicleBrandService vehicleBrandService;
	private VehicleService vehicleService;
	private Person person;
	
	@Autowired
	public PersonServiceImpl(PersonRepository repository, CityService cityService, 
			StateService stateService, NeighborhoodService neighborhoodService,
			VehicleBrandService vehicleBrandService, VehicleService vehicleService) {
		
		this.repository = repository;
		this.cityService = cityService;
		this.stateService = stateService;
		this.neighborhoodService = neighborhoodService;
		this.vehicleBrandService = vehicleBrandService;
		this.vehicleService = vehicleService;
		this.person = new Person();

	}

	@Override
	public void personSave(Person pessoa) {		
		List<Vehicle> listaTemp = null;
		this.person = pessoa;
		
		validatingAndInsertIfNotExistState();
		validatingAndInsertIfNotExistCity();
		validatingAndInsertIfNotExistNeighborhood();
		
		//TODO Implementar java 8 com lambda aqui.
		for (Vehicle vehicle : person.getListaVeic()) {
			 VehicleBrand vehicleBrandPerson = vehicle.getMarca();
			 listaTemp = new ArrayList<Vehicle>();
			
			if (null != vehicleBrandService.findVehicleBrandByIdOrName(vehicleBrandPerson).getIdMarcaVeic()) {
				vehicleBrandPerson = vehicleBrandService.findVehicleBrandByIdOrName(vehicleBrandPerson);
			} else {
				vehicleBrandService.VehicleBrandSave(vehicleBrandPerson);
				vehicleBrandPerson = vehicleBrandService.findVehicleBrandByIdOrName(vehicleBrandPerson);
			}
			
			if (null != vehicleService.findVehicle(vehicle).getIdVeic()) {
				vehicle = vehicleService.findVehicle(vehicle);
				vehicle.setMarca(vehicleBrandPerson);
			} else {
				vehicleService.vehicleSave(vehicle);
				vehicle = vehicleService.findVehicle(vehicle);
			}
			
			vehicle.setMarca(vehicleBrandPerson);
			
			listaTemp.add(vehicle);
		}
		
		person.setListaVeic(listaTemp);
		
		repository.personSave(person);
	}
	
	private void validatingAndInsertIfNotExistState() {
		State personState = stateService.findStateByIdOrNameOrInitials(this.person.getEndereco().getBairro().getCidade().getEstado());
		
		if (null != personState.getIdEstado()) {			
			this.person.getEndereco().getBairro().getCidade().setEstado(personState);
		} else {			
			stateService.stateSave(this.person.getEndereco().getBairro().getCidade().getEstado());
			
			this.person.getEndereco().getBairro().getCidade().setEstado(stateService.findStateByIdOrNameOrInitials(this.person.getEndereco()
																				  									.getBairro()
																				  									.getCidade()
																				  									.getEstado()));
		}
	}

	private void validatingAndInsertIfNotExistNeighborhood() {
		Neighborhood personNeighborhood = neighborhoodService.findNeighborhoodByIdOrName(this.person.getEndereco().getBairro());
		
		if (null != personNeighborhood.getIdBairro()) {			
			this.person.getEndereco().setBairro(personNeighborhood);
		} else {			
			neighborhoodService.neighborhoodSave(this.person.getEndereco().getBairro());
			
			this.person.getEndereco().setBairro(neighborhoodService.findNeighborhoodByIdOrName(this.person.getEndereco()
						  												  								  .getBairro()));
		}		
	}

	private void validatingAndInsertIfNotExistCity() {
		City personCity = cityService.findCityByIdOrName(this.person.getEndereco().getBairro().getCidade());
		
		if (null != personCity.getIdCidade()) {			
			this.person.getEndereco().getBairro().setCidade(personCity);
		} else {			
			cityService.saveCity(this.person.getEndereco().getBairro().getCidade());
			
			this.person.getEndereco().getBairro().setCidade(cityService.findCityByIdOrName(this.person.getEndereco()
						  								  											  .getBairro()
					  								  											  	  .getCidade()));
		}
	}

	@Override
	public List<Person> findAllPersonInfo() {		
		
		return repository.fullListPersonInfos();
	}
}
