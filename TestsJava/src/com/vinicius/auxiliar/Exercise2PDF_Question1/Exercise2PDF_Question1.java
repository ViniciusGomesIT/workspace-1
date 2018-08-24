package com.vinicius.auxiliar.Exercise2PDF_Question1;

import com.vinicius.interfaces.InterfaceRun;

public class Exercise2PDF_Question1 implements InterfaceRun {
	
	@Override
	public void run() {
		int i = 012;
		
		if (i == 10.0) {			
			System.out.println("Question01: When a integer have 0 as prefix its seems to be calculed in octal base...");
			System.out.println("If we use 012, its like (2 * 8 ^ 0 = 2) + (1 * 8 ^ 1 = 8)");
			
			System.out.println("---------");
		}
	}
}