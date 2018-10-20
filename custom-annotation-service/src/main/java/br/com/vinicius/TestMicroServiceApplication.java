package br.com.vinicius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "{br.com.vinicius}")
public class TestMicroServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TestMicroServiceApplication.class, args);
		
	}
}
