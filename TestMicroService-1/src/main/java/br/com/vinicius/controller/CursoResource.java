package br.com.vinicius.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vinicius.model.Curso;
import br.com.vinicius.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
@Controller
public class CursoResource {
 
  private Map<Integer, Curso> cursos;
  
  @Autowired
  private TestService service;
  
  @Autowired
  private ApplicationContext context;
  
  public CursoResource() {
    cursos = new HashMap<Integer, Curso>();
    
//    c1.setId(1);
//    c1.setNome("Workshop Rest");
//    c1.setDuracao("24hs");
    
//    Curso c2 = new Curso();
//    c2.setId(2);
//    c2.setNome("Workshop Spring MVC");
//    c2.setDuracao("24hs");
    
//    Curso c3 = new Curso();
//    c3.setId(3);
//    c3.setNome("Desenvolvimento Web com JSF 2");
//    c3.setDuracao("60hs");
 
//    cursos.put(1, c1);
//    cursos.put(2, c2);
//    cursos.put(3, c3);
    
//    System.out.println("c1: " + c1);
//    System.out.println("c2: " + c2);
    
    service.print();
     
  }
 
	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "Created", response = CursoResource.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Recupera os dados do cliente baseado no CPF/CNPJ informado")
  @RequestMapping(value = "/cursos", method = RequestMethod.GET)
  public ResponseEntity<List<Curso>> listar() {
    return new ResponseEntity<List<Curso>>(new ArrayList<Curso>(cursos.values()), HttpStatus.OK);
  }
 
}
