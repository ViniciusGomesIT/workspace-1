package br.com.vinicius.outros;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vinicius.entity.VehicleBrand;
import br.com.vinicius.service.VehicleBrandService;	

@Component("vehicleBrandMassgenerator")
public class VehicleBrandMassGenerator {

	@Autowired
	private VehicleBrandService service;

	public void gerarMassaMarcaVeic() {
		ArrayList<VehicleBrand> lista = new ArrayList<VehicleBrand>();
		ArrayList<String> listaDeNomes = new ArrayList<String>();

		listaDeNomes.add("Volvo");
		listaDeNomes.add("Fiat");
		listaDeNomes.add("Ford");
		listaDeNomes.add("VolksWagen");
		listaDeNomes.add("BMW");
		listaDeNomes.add("Audi");
		listaDeNomes.add("Mercedes");
		listaDeNomes.add("Chevrolet");
		listaDeNomes.add("Tesla");
		listaDeNomes.add("Maserati");
		listaDeNomes.add("Saab");
		listaDeNomes.add("GMC");
		listaDeNomes.add("Jac");
		listaDeNomes.add("Jeep");
		listaDeNomes.add("Toyota");
		listaDeNomes.add("Gurgel");
		listaDeNomes.add("Maybach");
		listaDeNomes.add("Shelby");
		listaDeNomes.add("Dodge");
		listaDeNomes.add("Honda");
		listaDeNomes.add("Lexus");
		listaDeNomes.add("Infiniti");
		listaDeNomes.add("Pontiac");
		listaDeNomes.add("Mazda");
		listaDeNomes.add("Mitsubishi");
		listaDeNomes.add("Hyundai");
		listaDeNomes.add("Subaru");
		listaDeNomes.add("Alfa Romeo");
		listaDeNomes.add("Chrysler");
		listaDeNomes.add("Land Rover");
		listaDeNomes.add("Lotus");
		listaDeNomes.add("Ferrarri");
		listaDeNomes.add("Lamborghini");
		listaDeNomes.add("Porsche");
		listaDeNomes.add("Corvette");
		listaDeNomes.add("Bugatti");
		listaDeNomes.add("Zonda");
		listaDeNomes.add("Bentley");
		listaDeNomes.add("Cherry");
		listaDeNomes.add("Suzuki");
		listaDeNomes.add("Nissan");
		listaDeNomes.add("Acura");
		listaDeNomes.add("Cadillac");
		listaDeNomes.add("Buick");
		listaDeNomes.add("Peugeot");
		listaDeNomes.add("Renault");
		listaDeNomes.add("Citroen");
		listaDeNomes.add("Aston Martion");
		listaDeNomes.add("Rolls Royce");
		listaDeNomes.add("Kia");
		listaDeNomes.add("Mini");
		listaDeNomes.add("Daewoo");
		listaDeNomes.add("Jaguar");
		listaDeNomes.add("SsangYong");
		listaDeNomes.add("Hummer");
		listaDeNomes.add("Lincoln");

		for (String texto : listaDeNomes) {
			VehicleBrand marca = new VehicleBrand();
			marca.setNome(texto);

			lista.add(marca);
		}

		for (VehicleBrand marcaVeic : lista) {
			marcaVeic.setNome(marcaVeic.getNome().toUpperCase());
			service.VehicleBrandSave(marcaVeic);
		}

	}

}
