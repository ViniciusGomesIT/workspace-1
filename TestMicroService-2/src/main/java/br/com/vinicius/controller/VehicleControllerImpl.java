package br.com.vinicius.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import br.com.vinicius.rest.request.VehiclePersonRequest;
import br.com.vinicius.rest.resource.VehicleResource;
import br.com.vinicius.rest.response.VehicleBrandResponse;
import br.com.vinicius.rest.response.VehicleResponse;

@Controller
public class VehicleControllerImpl implements VehicleResource {

	@Override
	public ResponseEntity<List<VehicleBrandResponse>> getAllVehicleBrand() {
		// TODO Adicionar implementação do método
		return null;
	}

	@Override
	public ResponseEntity<List<VehicleResponse>> getPersonVehicle(@Valid VehiclePersonRequest request) {
		// TODO Adicionar implementação do método
		return null;
	}

}
