package br.com.vinicius.repository;

import java.util.List;

import br.com.vinicius.entity.Person;

public interface PersonRepository {

	Person findPersonById(Long id);

	Person finPersonByCpfOrRg(String cpfOrRg);

	List<Person> findAllPersons();

	void personSave(Person pessoa);

	void deletePerson(Person pessoa);

	List<Person> fullListPersonInfos();

}