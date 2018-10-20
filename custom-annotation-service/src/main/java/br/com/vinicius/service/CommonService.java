package br.com.vinicius.service;

import br.com.vinicius.model.Cliente;
import br.com.vinicius.rest.response.DadosClienteResponse;

public interface CommonService {

	DadosClienteResponse parseResponse(Cliente cliente);
}
