package br.com.vinicius.rest.resource;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vinicius.annotations.CPFOrCNPJ;
import br.com.vinicius.rest.request.DadosClienteRequest;
import br.com.vinicius.rest.response.DadosClienteResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Cliente", description = "Persistir dados do cliente na base")
public interface EndpointResource {

	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "Created", response = DadosClienteResponse.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Recupera os dados do cliente baseado no CPF/CNPJ informado",
			response = DadosClienteResponse.class)
	@RequestMapping(value = "/{document}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<DadosClienteResponse> findDadosCliente(@PathVariable("document") @CPFOrCNPJ String document, @RequestBody @Valid DadosClienteRequest request);
}
