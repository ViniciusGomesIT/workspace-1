package br.com.vinicius.rest.request;

import javax.validation.constraints.NotNull;

public class VehiclePersonRequest {
	
	@NotNull(message = "É necessário informar o id da pessoa")
	private Long idPerson;

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}
	
}
