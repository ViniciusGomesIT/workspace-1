package br.com.vinicius.controller.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vinicius.controller.VehicleResource;
import br.com.vinicius.model.Vehicle;
import br.com.vinicius.model.VehicleBrand;
import br.com.vinicius.rest.request.VehiclePersonRequest;
import io.swagger.annotations.Api;

@Controller
@Api
public class VehicleControllerImpl implements VehicleResource {

	@Override
	@RequestMapping(value = "/vehicle-brand", method = RequestMethod.GET)
	public ResponseEntity<List<VehicleBrand>> getAllVehicleBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
//	@RequestMapping(value = "/vehicle-person", method = RequestMethod.POST, @Valid VehiclePersonRequest.class)
	public ResponseEntity<List<Vehicle>> getPersonVehicle() {
		// TODO Auto-generated method stub
		return null;
	}

}
