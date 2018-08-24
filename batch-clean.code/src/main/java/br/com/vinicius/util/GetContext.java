package br.com.vinicius.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import br.com.vinicius.AppConfig;

public class GetContext {
	
	public ApplicationContext getContext() {
		return new AnnotationConfigApplicationContext(AppConfig.class);
	}	
}