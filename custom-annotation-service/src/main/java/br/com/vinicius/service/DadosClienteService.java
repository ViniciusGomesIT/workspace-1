package br.com.vinicius.service;

import br.com.vinicius.model.Cliente;

public interface DadosClienteService {

	Cliente findClienteData(String document, String authenticated);
}
