package br.com.vinicius.outros;

import java.sql.Date;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vinicius.controller.PersonController;
import br.com.vinicius.entity.Neighborhood;
import br.com.vinicius.entity.City;
import br.com.vinicius.entity.Address;
import br.com.vinicius.entity.State;
import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.entity.Person;
import br.com.vinicius.entity.Vehicle;

@Component("personMassGenerator")
public class PersonMassGenerator {

	private PersonController personController;
	private Person person;
	private Vehicle vehicle;

	@Autowired
	public PersonMassGenerator(PersonController personController) {
		this.personController = personController;
		this.person = new Person();
		this.vehicle = new Vehicle();
	}

	public void gerarMassaPessoa() {

		person.setNomePessoa("Maria do teste");
		person.setRg("8884391");
		person.setCpf("10430935404");
		person.setDataNascimento(new Date(System.currentTimeMillis()));

		person.setEndereco(new Address());
		person.getEndereco().setLogradouro("Avenida Norte Miguel Araes de Alencar, 1536");
		person.getEndereco().setComplemento("");
		person.getEndereco().setNumero(0);

		person.getEndereco().setBairro(new Neighborhood());
		person.getEndereco().getBairro().setNomeBairro("Jaboatão Centro");

		person.getEndereco().getBairro().setCidade(new City());
		person.getEndereco().getBairro().getCidade().setNomeCidade("Jaboatão dos Guararapes");

		person.getEndereco().getBairro().getCidade().setEstado(new State());
		person.getEndereco().getBairro().getCidade().getEstado().setNomeEstado("Pernambuco");
		person.getEndereco().getBairro().getCidade().getEstado().setSigla("PE");

		vehicle.setMarca(new VehicleBrand());
		vehicle.getMarca().setNome("Honda");
		vehicle.setModeloVeic("Civic 2.0 TSI");
		vehicle.setCor("Prata");
		vehicle.setAnoFabricacao(2016);
		vehicle.setAnoModelo(2017);

		person.setListaVeic(new ArrayList<Vehicle>());
		person.getListaVeic().add(vehicle);

		personController.personSave(person);

	}
}
