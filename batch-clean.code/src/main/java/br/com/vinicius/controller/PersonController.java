package br.com.vinicius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vinicius.entity.Person;
import br.com.vinicius.service.PersonService;

@Component("personController")
public class PersonController {

	@Autowired
	private PersonService service;

	public void personSave(Person person) {
		service.personSave(person);		
	}
}