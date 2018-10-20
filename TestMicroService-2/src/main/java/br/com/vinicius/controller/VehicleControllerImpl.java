package br.com.vinicius.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import br.com.vinicius.builder.VehicleBrandResponseBuilder;
import br.com.vinicius.rest.resource.VehicleResource;
import br.com.vinicius.rest.response.VehicleBrandResponse;
import br.com.vinicius.service.impl.VehicleServiceImpl;

@Controller
public class VehicleControllerImpl implements VehicleResource {
	
	private VehicleServiceImpl service;

	@Inject
	public VehicleControllerImpl(VehicleServiceImpl service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<List<VehicleBrandResponse>> getAllVehicleBrand() {
		return new ResponseEntity<List<VehicleBrandResponse>>( VehicleBrandResponseBuilder
					.vehicleBrandResponseBuilder()
					.convert( service.getAllVehicleBrand() ), HttpStatus.OK );	
	}

	//TODO realocar para o controller do usuário
//	@Override
//	public ResponseEntity<List<VehicleResponse>> getPersonVehicle(@Valid VehiclePersonRequest request) {
//		return new ResponseEntity<List<VehicleResponse>>( VehicleResponseBuilder
//					.vehicleResponseBuilder()
//					.convert( service.getPersonVehicles() ), HttpStatus.OK );
//	}

}
