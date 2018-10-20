package br.com.vinicius.service.impl;

import java.sql.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import br.com.vinicius.model.Cliente;
import br.com.vinicius.service.DadosClienteService;

@Component
public class DadosClienteServiceImpl implements DadosClienteService {
	
	@Inject
	private Cliente cliente;

	@Override
	public Cliente findClienteData(String document, String authenticated) {
		if (authenticated.equalsIgnoreCase("password")) {
			return populaClienteAuthenticated();
		} else {
			return populaClienteNotAuthenticated();
		}

	}

	private Cliente populaClienteNotAuthenticated() {
		this.cliente.setId(150L);
		this.cliente.setFirstName("Haryanne");
		this.cliente.setSecondName("Alves");
		this.cliente.setBirthday(new Date(System.currentTimeMillis()));
		return cliente;
	}

	private Cliente populaClienteAuthenticated() {
		this.cliente.setId(55L);
		this.cliente.setFirstName("Vinicius");
		this.cliente.setSecondName("Gomes");
		this.cliente.setBirthday(new Date(System.currentTimeMillis()));
		return cliente;
	}

}
