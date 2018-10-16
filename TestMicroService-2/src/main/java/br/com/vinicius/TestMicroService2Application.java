package br.com.vinicius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.vinicius"})
public class TestMicroService2Application {

	public static void main(String[] args) {
		SpringApplication.run(TestMicroService2Application.class, args);
	}
}
