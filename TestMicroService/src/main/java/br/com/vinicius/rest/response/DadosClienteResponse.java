package br.com.vinicius.rest.response;

import br.com.vinicius.model.Cliente;

public class DadosClienteResponse {

	private Cliente cliente;
	private String authenticationType;
	
	public DadosClienteResponse(Cliente cliente) {
		this.cliente = cliente;
		this.authenticationType = "Authenticated";
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getAuthenticationType() {
		return authenticationType;
	}
	public void setAuthenticationType(String authenticationType) {
		this.authenticationType = authenticationType;
	}
	
	
	
}
