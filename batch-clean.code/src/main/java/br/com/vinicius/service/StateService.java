package br.com.vinicius.service;

import br.com.vinicius.entity.State;

public interface StateService {

	State findStateByIdOrNameOrInitials(State state);

	void stateSave(State state);

	void deleteState(State state);

}