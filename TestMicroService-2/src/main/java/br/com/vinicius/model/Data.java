package br.com.vinicius.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Data {
	
	@Value("${data.name}")
	private String name;
	
	@Value("${data.lastName}")
	private String lastName;
	
	@Value("${data.age}")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Data [name=" + name + ", lastName=" + lastName + ", age=" + age + "]";
	}
}
