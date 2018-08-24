package br.com.vinicius.service;

import java.util.List;

import br.com.vinicius.entity.Person;

public interface PersonService {

	void personSave(Person pessoa);

	List<Person> findAllPersonInfo();

}