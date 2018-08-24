package com.vinicius.auxiliar.Exercise2PDF_Question6;

public class Question6Main {
	
	public static void main(String[] args) {
		Derived d = new DeriDerived();
		
		System.out.println();
		System.out.println("Question06: The methods that are called follow the hierarchy of who extends. In our case, \n" + 
				"Derived call Base and DeriDerived call Derived.. So when we call Derived d = new DeriDerived \n" + 
				"we calling first Base, second Derived and third DeriDerived;");
		System.out.println("---------");
	}

}
