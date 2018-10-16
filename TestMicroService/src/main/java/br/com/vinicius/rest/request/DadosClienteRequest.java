package br.com.vinicius.rest.request;

import javax.validation.constraints.NotNull;

public class DadosClienteRequest {

	@NotNull(message="Método de authenticação não informado")
	private String authenticated;

	public String getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(String authenticated) {
		this.authenticated = authenticated;
	}
	
	
}
