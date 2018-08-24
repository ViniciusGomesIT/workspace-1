package br.com.vinicius.service;

import java.util.ArrayList;
import java.util.List;

import br.com.vinicius.entity.City;
import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.entity.Person;
import br.com.vinicius.entity.State;
import br.com.vinicius.entity.Vehicle;
import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.repository.PersonRepository;

public class PersonService {

	PersonRepository repository;
	CityService cityService;
	StateService stateService;
	NeighborhoodService neighborhoodService;
	VehicleBrandService vehicleBrandService;
	VehicleService vehicleService;
	
	public PersonService() {
		
		this.repository = new PersonRepository();
		this.cityService = new CityService();
		this.stateService = new StateService();
		this.neighborhoodService = new NeighborhoodService();
		this.vehicleBrandService = new VehicleBrandService();
		this.vehicleService = new VehicleService();
	}

	public String personSave(Person pessoa) {
		List<Vehicle> listaTemp = null;

		Neighborhood personNeighborhood = neighborhoodService.findNeighborhoodByIdOrName(pessoa.getEndereco()
																					   .getBairro());
		
		City personCity = cityService.findCityByIdOrName(pessoa.getEndereco()
													   .getBairro()
													   .getCidade());
		
		State personState = stateService.findStateByIdOrName(pessoa.getEndereco()
														   .getBairro()
														   .getCidade()
														   .getEstado());
						
		if (null != personState) {
			
			pessoa.getEndereco()
				  .getBairro()
				  .getCidade()
				  .setEstado(personState);
		} else {
			
			stateService.stateSave(pessoa.getEndereco()
					    .getBairro()
					    .getCidade()
					    .getEstado());
			
			pessoa.getEndereco()
				  .getBairro()
				  .getCidade()
				  .setEstado(stateService.findStateByIdOrName(pessoa.getEndereco()
						  									.getBairro()
						  									.getCidade()
						  									.getEstado()));
		}
		
		if (null != personCity) {			
			pessoa.getEndereco()
				  .getBairro()
				  .setCidade(personCity);
		} else {			
			cityService.saveCity(pessoa.getEndereco()
		   			   .getBairro()
		   			   .getCidade());
			
			pessoa.getEndereco()
				  .getBairro()
				  .setCidade(cityService.findCityByIdOrName(pessoa.getEndereco()
						  								  .getBairro()
						  								  .getCidade()));
		}
		
		if (null != personNeighborhood) {			
			pessoa.getEndereco()
				  .setBairro(personNeighborhood);
		} else {
			
			neighborhoodService.neighborhoodSave(pessoa.getEndereco()
													   .getBairro());
			
			pessoa.getEndereco()
				  .setBairro(neighborhoodService.findNeighborhoodByIdOrName(pessoa.getEndereco()
						  												  .getBairro()));
		}
		
		for (Vehicle vehicle : pessoa.getListaVeic()) {
			 VehicleBrand vehicleBrandPerson = vehicle.getMarca();
			 listaTemp = new ArrayList<Vehicle>();
			
			if (null != vehicleBrandService.findVehicleBrandByIdOrName(vehicleBrandPerson)) {
				vehicleBrandPerson = vehicleBrandService.findVehicleBrandByIdOrName(vehicleBrandPerson);
			} else {
				vehicleBrandService.VehicleBrandSave(vehicleBrandPerson);
				vehicleBrandPerson = vehicleBrandService.findVehicleBrandByIdOrName(vehicleBrandPerson);
			}
			
			if (null != vehicleService.findVehicle(vehicle)) {
				vehicle = vehicleService.findVehicle(vehicle);
				vehicle.setMarca(vehicleBrandPerson);
			} else {
				vehicleService.vehicleSave(vehicle);
				vehicle = vehicleService.findVehicle(vehicle);
			}
			
			vehicle.setMarca(vehicleBrandPerson);
			
			listaTemp.add(vehicle);
		}
		
		pessoa.setListaVeic(listaTemp);
		
		String result = repository.personSave(pessoa);

		return result;
	}
	
	public List<Person> findAllPersonInfo() {		
		
		return repository.fullListPersonInfos();
	}
}
