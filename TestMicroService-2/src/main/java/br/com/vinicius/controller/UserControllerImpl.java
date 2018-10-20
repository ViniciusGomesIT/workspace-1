package br.com.vinicius.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import br.com.vinicius.model.User;
import br.com.vinicius.rest.resource.UserResources;
import br.com.vinicius.service.impl.UserServiceImpl;

@Controller
public class UserControllerImpl implements UserResources {

	private UserServiceImpl service;

	@Inject
	public UserControllerImpl(UserServiceImpl service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<User> getUserInfo() {
		return new ResponseEntity<User>(service.getUserInfo(), HttpStatus.OK);
	}

}
