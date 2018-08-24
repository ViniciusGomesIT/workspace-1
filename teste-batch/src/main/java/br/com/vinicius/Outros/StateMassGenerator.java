package br.com.vinicius.Outros;

import br.com.vinicius.entity.State;
import br.com.vinicius.repository.StateRepository;

public class StateMassGenerator {

	public void gerarMassaEstado() {
		State estado = new State();
		StateRepository repository = new StateRepository();

		estado.setNomeEstado("Penambuco");
		estado.setSigla("PE");

		if (null == repository.findStateByName(estado.getNomeEstado())) {
			repository.stateSave(estado);
		} else {
			System.out.println("Estado " + estado.getNomeEstado() + " já existe na base");
		}

	}
}
