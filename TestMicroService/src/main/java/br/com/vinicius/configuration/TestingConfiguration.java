package br.com.vinicius.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestingConfiguration {
	
	@Value("${file.name}")
	private String name;
	
	@Value("${file.path}")
	private String password;
	
	public void printProperties() {
		System.out.println(name.concat(" ").concat(password));
	}

}
