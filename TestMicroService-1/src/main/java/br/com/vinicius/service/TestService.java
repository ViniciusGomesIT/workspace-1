package br.com.vinicius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.model.Curso;

@Service
public class TestService {

	  @Autowired
	  private Curso c1;
	  
	  public void print() {
		  System.out.println("Service C1: " + c1);
	  }
}
