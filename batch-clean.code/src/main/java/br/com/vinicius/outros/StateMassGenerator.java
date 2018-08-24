package br.com.vinicius.outros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vinicius.entity.State;
import br.com.vinicius.repository.StateRepository;
import br.com.vinicius.repository.impl.StateRepositoryImpl;

@Component("stateMassGenerator")
public class StateMassGenerator {
	
	@Autowired
	private StateRepository repository;
	
	@Autowired
	private State state;

	public void gerarMassaEstado() {
		
		state.setNomeEstado("Penambuco");
		state.setSigla("PE");

		if (null == repository.findStateByName(state.getNomeEstado())) {
			repository.stateSave(state);
		} else {
			System.out.println("Estado " + state.getNomeEstado() + " já existe na base");
		}

	}
}
