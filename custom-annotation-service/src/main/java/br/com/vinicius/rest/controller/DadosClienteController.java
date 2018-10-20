package br.com.vinicius.rest.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vinicius.rest.request.DadosClienteRequest;
import br.com.vinicius.rest.resource.EndpointResource;
import br.com.vinicius.rest.response.DadosClienteResponse;
import br.com.vinicius.service.CommonService;
import br.com.vinicius.service.DadosClienteService;

@RestController
public class DadosClienteController implements EndpointResource {
	
	@Inject
	CommonService commonService;
	@Inject
	DadosClienteService dadosClienteService;

	@Override	
	public ResponseEntity<DadosClienteResponse> findDadosCliente(String document, @Valid DadosClienteRequest request) {
		return ResponseEntity.ok(
				commonService.parseResponse(
						dadosClienteService.findClienteData(document, request.getAuthenticated() )
						)
				);
	}
}
