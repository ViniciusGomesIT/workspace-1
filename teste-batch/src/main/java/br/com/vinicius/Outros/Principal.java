package br.com.vinicius.Outros;

import br.com.vinicius.controller.FileController;

public class Principal {

	public static void main(String[] args) {
//		GeradorMassaMarcaVeic gmv = new GeradorMassaMarcaVeic();
//		GeradorMassaEstado gme = new GeradorMassaEstado();		
		PersonMassGenerator gmp = new PersonMassGenerator();
		FileController fc = new FileController();
		
//		gmv.gerarMassaMarcaVeic();	
//		gme.gerarMassaEstado();
		for (int i = 0; i < 6; i++) {
			gmp.gerarMassaPessoa();			
		}		
		fc.generatingFile();
		
	}

}
