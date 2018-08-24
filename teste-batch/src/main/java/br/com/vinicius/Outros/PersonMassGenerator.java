package br.com.vinicius.Outros;

import java.sql.Date;
import java.util.ArrayList;

import br.com.vinicius.controller.PersonController;
import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.entity.City;
import br.com.vinicius.entity.Address;
import br.com.vinicius.entity.State;
import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.entity.Person;
import br.com.vinicius.entity.Vehicle;

public class PersonMassGenerator {

	public void gerarMassaPessoa() {
		PersonController controller = new PersonController();
		Person pessoa = new Person();
		Vehicle veic = new Vehicle();
		
		pessoa.setNomePessoa("Maria do teste");
		pessoa.setRg("8884391");
		pessoa.setCpf("10430935404");
		pessoa.setDataNascimento(new Date(System.currentTimeMillis()));
		
		pessoa.setEndereco(new Address());		
		pessoa.getEndereco().setLogradouro("Avenida Norte Miguel Araes de Alencar, 1536");
		pessoa.getEndereco().setComplemento("");
		pessoa.getEndereco().setNumero(0);
		
		pessoa.getEndereco().setBairro(new Neighborhood());		
		pessoa.getEndereco().getBairro().setNomeBairro("Jaboatão Centro");
		
		pessoa.getEndereco().getBairro().setCidade(new City());
		pessoa.getEndereco().getBairro().getCidade().setNomeCidade("Jaboatão dos Guararapes");
		
		pessoa.getEndereco().getBairro().getCidade().setEstado(new State());
		pessoa.getEndereco().getBairro().getCidade().getEstado().setNomeEstado("Pernambuco");
		pessoa.getEndereco().getBairro().getCidade().getEstado().setSigla("PE");
		
		veic.setMarca(new VehicleBrand());
		veic.getMarca().setNome("Honda");
		veic.setModeloVeic("Civic 2.0 TSI");
		veic.setCor("Prata");
		veic.setAnoFabricacao(2016);
		veic.setAnoModelo(2017);

		pessoa.setListaVeic(new ArrayList<Vehicle>());
		pessoa.getListaVeic().add(veic);
		
		controller.personSave(pessoa);
		
	}
}
