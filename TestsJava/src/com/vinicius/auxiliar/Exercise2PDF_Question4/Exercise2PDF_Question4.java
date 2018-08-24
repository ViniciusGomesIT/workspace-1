package com.vinicius.auxiliar.Exercise2PDF_Question4;

import com.vinicius.interfaces.InterfaceRun;

public class Exercise2PDF_Question4 implements InterfaceRun {

	@Override
	public void run() {
		Object nullObj = null;
		StringBuffer str = new StringBuffer(10);
		
		str.append("Hello ");
		str.append("world ");
		str.append(nullObj);
		str.insert(11, "!");
		
		System.out.println(str);
		
		System.out.println("Question04: The number \"10\" in constructors is the initial capacity os buffer not the final capacity. \n" + 
				"It's can be increased if it's needed. When whe set a null object in the append method, it's use the \n" + 
				".toString() method to put in StringBuffer. So, a null object changes to \"null\";");
		System.out.println("---------");
	}
}
