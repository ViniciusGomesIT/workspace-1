package com.vinicius.auxiliar.Exercise2PDF_Question3;

import com.vinicius.interfaces.InterfaceRun;

public class Exercise2PDF_Question3 implements InterfaceRun {

	@Override
	public void run() {
		StringBuffer str = new StringBuffer("This, that, etc.!");
		System.out.println(str.replace(12, 15, "etcetera"));
		
		System.out.println("Question03: The parameters of method string.replace(int begin, int end) is inclusive in beginning" + 
				" and exclusive in the end;");
		System.out.println("---------");
	}
}
