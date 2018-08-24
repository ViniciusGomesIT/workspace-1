package com.vinicius.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vinicius.AppConfig;
import com.vinicius.service.TesteService;

public class TesteMain {

	public static void main(String[] args) {
		ApplicationContext context =  new AnnotationConfigApplicationContext(AppConfig.class);
				
		TesteService service = context.getBean("testeService", TesteService.class);
		
		service.insertOrUpdate();
	}

}
