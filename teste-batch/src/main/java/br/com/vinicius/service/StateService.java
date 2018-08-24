package br.com.vinicius.service;

import br.com.vinicius.entity.State;
import br.com.vinicius.repository.StateRepository;

public class StateService {

	private StateRepository repository;

	public StateService() {		
		this.repository = new StateRepository();
	}
	
	public State findStateByIdOrName(State state) {		
		if (null != state.getIdEstado()) {
			return repository.findStateById(state.getIdEstado());
		} else if (null != state.getNomeEstado()) {
			 return repository.findStateByName(state.getNomeEstado().toUpperCase());
		} else if (null != state.getSigla()) {
			return repository.findStateByInitials(state.getSigla().toUpperCase());
		} else {
			return null;
		}
	}
	
	public String stateSave(State state) {		
		state.setNomeEstado(state.getNomeEstado().toUpperCase());
		
		String result = repository.stateSave(state);
		
		return result;
	}
	
	public String deleteState(State state) {		
		String result = null;
		
		if (null != state.getIdEstado()) {
			result = repository.deleteState(repository.findStateById(state.getIdEstado()));
			return result;
		} else if (null != state.getNomeEstado()) {
			result = repository.deleteState(repository.findStateByName(state.getNomeEstado().toUpperCase()));
			return result;
		} else if (null != state.getSigla()) {
			result = repository.deleteState(repository.findStateByInitials(state.getSigla().toUpperCase()));
			return result;
		} else {
			return null;
		}
	}
}