package com.vinicius;

import com.vinicius.auxiliar.Exercise2PDF_Question1.Exercise2PDF_Question1;
import com.vinicius.auxiliar.Exercise2PDF_Question2.Exercise2PDF_Question2;
import com.vinicius.auxiliar.Exercise2PDF_Question3.Exercise2PDF_Question3;
import com.vinicius.auxiliar.Exercise2PDF_Question4.Exercise2PDF_Question4;
import com.vinicius.auxiliar.Exercise2PDF_Question5.Exercise2PDF_Question5;
import com.vinicius.auxiliar.Exercise2PDF_Question6.Question6Main;
import com.vinicius.auxiliar.Exercise2PDF_Question7.Exercise2PDF_Question7;

public class Testes {

	public static void main(String[] args) {
		// ---------------------------------------- //
		Exercise2PDF_Question1 q1 = new Exercise2PDF_Question1();
		q1.run();
		
		// ---------------------------------------- //
		Exercise2PDF_Question2 q2 = new Exercise2PDF_Question2();
		q2.run();
		
		// ---------------------------------------- //
		Exercise2PDF_Question3 q3 = new Exercise2PDF_Question3();
		q3.run();
		
		// ---------------------------------------- //
		Exercise2PDF_Question4 q4 = new Exercise2PDF_Question4();
		q4.run();
		
		// ---------------------------------------- //
		Exercise2PDF_Question5 q5 = new Exercise2PDF_Question5();
		q5.run();
		
		// ---------------------------------------- //
		Question6Main.main(args);
		
		// ---------------------------------------- //
		Exercise2PDF_Question7 q7 = new Exercise2PDF_Question7();
		q7.run();
		
		
	}
}