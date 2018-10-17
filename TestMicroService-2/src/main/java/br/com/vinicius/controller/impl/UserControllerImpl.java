package br.com.vinicius.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.vinicius.controller.UserResources;
import br.com.vinicius.model.User;
import br.com.vinicius.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@Api
public class UserControllerImpl implements UserResources {

	@Autowired
	UserServiceImpl service;

	@Override
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ApiResponses( value = {
			@ApiResponse(code = 201, message = "Created", response = User.class),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	@ApiOperation(value = "Recupera os dados dos usuários.")
	public ResponseEntity<User> getUserInfo() {
		return new ResponseEntity<User>(service.getUserInfo(), HttpStatus.OK);
	}

}
