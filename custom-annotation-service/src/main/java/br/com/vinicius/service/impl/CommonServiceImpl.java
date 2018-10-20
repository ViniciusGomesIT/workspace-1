package br.com.vinicius.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import br.com.vinicius.configuration.TestingConfiguration;
import br.com.vinicius.model.Cliente;
import br.com.vinicius.rest.response.DadosClienteResponse;
import br.com.vinicius.service.CommonService;

@Component
public class CommonServiceImpl implements CommonService {
	
	@Inject
	DadosClienteResponse response;

	@Override
	public DadosClienteResponse parseResponse(Cliente cliente) {
		
		response.setCliente(cliente);
		
		if (cliente.getFirstName().equalsIgnoreCase("vinicius")) {
			response.setAuthenticationType("password");
		} else {
			response.setAuthenticationType("token");
		}
		
		return response;
	}

	public void print() {
		TestingConfiguration config = new TestingConfiguration();
		
		config.printProperties();
	}

}
