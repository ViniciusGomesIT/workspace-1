package br.com.vinicius.rest.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vinicius.rest.request.VehiclePersonRequest;
import br.com.vinicius.rest.response.VehicleBrandResponse;
import br.com.vinicius.rest.response.VehicleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Api para obter informações do veículo")
public interface VehicleResource {
	
	@ApiResponses({
		@ApiResponse(code = 201, message = "Created", response = VehicleBrandResponse.class),
		@ApiResponse(code = 400, message = "Bad Request"),
		@ApiResponse(code = 404, message = "Not Found"),
		@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Retorna a lista de veículos cadastrados")
	@RequestMapping(value = "/vehicle-brand", 
		method = RequestMethod.GET)
	ResponseEntity<List<VehicleBrandResponse>> getAllVehicleBrand();

	//TODO realocar para o endpoint do usuário
//	@ApiResponses({ 
//		@ApiResponse(code = 201, message = "Created", response = VehicleBrandResponse.class),
//		@ApiResponse(code = 400, message = "Bad Request"),
//		@ApiResponse(code = 404, message = "Not Found"),
//		@ApiResponse(code = 500, message = "Internal Server Error"),
//	})
//	@ApiOperation(value = "Retorna a lista de veículos do usuário")
//	@RequestMapping(value = "/vehicle-person", 
//		method = RequestMethod.POST, 
//		consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	ResponseEntity<List<VehicleResponse>> getPersonVehicle(@RequestBody @Valid VehiclePersonRequest request);
}
