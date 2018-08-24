package com.vinicius.auxiliar.Exercise2PDF_Question5;

import com.vinicius.interfaces.InterfaceRun;

public class Exercise2PDF_Question5 implements InterfaceRun {

	@Override
	public void run() {
		//changed to scape of nullpointer
		//the original value is null
		Boolean b = false;
		
		System.out.println(b ? true : false);
		
		System.out.println("Question05: When boolean is setted with null and we try retrieve it's value we got a nullpointer.");
		System.out.println("---------");
	}

}
