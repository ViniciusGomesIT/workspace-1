package br.com.vinicius.repository;

import br.com.vinicius.entity.State;

public interface StateRepository {

	State findStateByName(String nome);

	State findStateByInitials(String initials);

	State findStateById(Long id);

	void stateSave(State state);

	void deleteState(State state);

}