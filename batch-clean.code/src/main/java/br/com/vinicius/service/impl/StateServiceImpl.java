package br.com.vinicius.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.entity.State;
import br.com.vinicius.repository.StateRepository;
import br.com.vinicius.service.StateService;

@Service("stateService")
public class StateServiceImpl implements StateService {

	@Autowired
	private StateRepository repository;
	
	private static final String STRING_FIELD_EMPTY = "";
	private static final Long LONG_FIELD_EMPTY = 0L;

	@Override
	public State findStateByIdOrNameOrInitials(State state) {	
		checkAndBreakIfFieldNull(state);
		
		Optional<Long> idState = Optional.ofNullable(state.getIdEstado());
		
		if (idState.isPresent()) {
			return repository.findStateById(state.getIdEstado());
		} else if (null != state.getNomeEstado()) {
			 return repository.findStateByName(state.getNomeEstado());
		} else {
			return repository.findStateByInitials(state.getSigla());
		} 
	}
	
	@Override
	public void stateSave(State state) {	
		
		repository.stateSave(state);		
	}
	
	@Override
	public void deleteState(State state) {		
		checkAndBreakIfFieldNull(state);
		
		Optional<Long> idState = Optional.ofNullable(state.getIdEstado());
		
		if (idState.isPresent()) {
			repository.deleteState(repository.findStateById(state.getIdEstado()));
		} else if (null != state.getNomeEstado()) {
			repository.deleteState(repository.findStateByName(state.getNomeEstado().toUpperCase()));
		} else {
			repository.deleteState(repository.findStateByInitials(state.getSigla().toUpperCase()));
		} 
	}
	
	private void checkAndBreakIfFieldNull(State state) {
		if (LONG_FIELD_EMPTY == state.getIdEstado()
				&& STRING_FIELD_EMPTY.equals(state.getNomeEstado().trim())
				&& STRING_FIELD_EMPTY.equals(state.getSigla().trim())) {
			
			throw new IllegalArgumentException("Não foi informado o ID, NOME nem SIGLA do Estado");
		}
		
	}
}