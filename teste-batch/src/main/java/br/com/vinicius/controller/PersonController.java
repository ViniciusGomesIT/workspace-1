package br.com.vinicius.controller;

import br.com.vinicius.entity.Person;
import br.com.vinicius.service.PersonService;

public class PersonController {

	private PersonService service;

	public PersonController() {
		this.service = new PersonService();
	}

	public void personSave(Person person) {
		String result = service.personSave(person);

		if (result.contains("sucesso")) {
			System.out.println(result);
		} else {
			System.out.println("Não foi possível salvar a pessoa " + person.getNomePessoa());
		}
	}
}