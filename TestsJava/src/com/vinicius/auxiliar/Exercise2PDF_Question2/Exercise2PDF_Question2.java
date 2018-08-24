package com.vinicius.auxiliar.Exercise2PDF_Question2;

import java.math.BigDecimal;

import com.vinicius.interfaces.InterfaceRun;

public class Exercise2PDF_Question2 implements InterfaceRun {
	
	@Override
	public void run() {
		Number[] numbers = new Number[4];
		
		numbers[0] = new Double(50);
		numbers[1] = new Integer(1);
		numbers[2] = new Float(2.0f);
		numbers[3] = new BigDecimal(3.0);
		
		for (Number number : numbers) {
			System.out.print(number + " - ");
		}
		
		System.out.println();
		System.out.println("Question02: Number is a abstract class and need that subclasses implements a convertable method");
		System.out.println("So, one number cannot receive a new Number, only a subclass of it's");
		System.out.println("And it's only works with  BigDecimal, BigInteger, Byte, Double, Float, Integer, Long, and Short");
		
		System.out.println("---------");
		
	}

}
