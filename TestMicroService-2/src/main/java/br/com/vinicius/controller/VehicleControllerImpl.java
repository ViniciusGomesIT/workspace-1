package br.com.vinicius.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import br.com.vinicius.builder.VehicleBrandResponseBuilder;
import br.com.vinicius.builder.VehicleResponseBuilder;
import br.com.vinicius.rest.request.VehiclePersonRequest;
import br.com.vinicius.rest.resource.VehicleResource;
import br.com.vinicius.rest.response.VehicleBrandResponse;
import br.com.vinicius.rest.response.VehicleResponse;
import br.com.vinicius.service.impl.VehicleServiceImpl;

@Controller
public class VehicleControllerImpl implements VehicleResource {
	
	@Inject
	VehicleServiceImpl service;

	@Override
	public ResponseEntity<List<VehicleBrandResponse>> getAllVehicleBrand() {
		return new ResponseEntity<List<VehicleBrandResponse>>( VehicleBrandResponseBuilder
					.vehicleBrandResponseBuilder()
					.convert( service.getAllVehicleBrand() ), HttpStatus.OK );	
	}

	@Override
	public ResponseEntity<List<VehicleResponse>> getPersonVehicle(@Valid VehiclePersonRequest request) {
		return new ResponseEntity<List<VehicleResponse>>( VehicleResponseBuilder
					.vehicleResponseBuilder()
					.convert( service.getPersonVehicles() ), HttpStatus.OK );
	}

}
