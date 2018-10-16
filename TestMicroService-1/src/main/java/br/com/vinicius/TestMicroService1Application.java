package br.com.vinicius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import br.com.vinicius.model.Curso;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.com.vinicius"} )
public class TestMicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(TestMicroService1Application.class, args);
		
//		Curso curso = (Curso) context.getBean(Curso.class);
//		
//		System.out.println(curso);
	}
}
