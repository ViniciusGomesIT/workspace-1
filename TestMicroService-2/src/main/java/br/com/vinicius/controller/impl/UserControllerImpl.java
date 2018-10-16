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

@Controller
public class UserControllerImpl implements UserResources {

	@Autowired
	UserServiceImpl service;

	@Override
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<User> getUserInfo() {
		System.out.println(service.getUserInfo());

		return new ResponseEntity<User>(service.getUserInfo(), HttpStatus.OK);
	}

}
