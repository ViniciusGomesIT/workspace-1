package br.com.vinicius.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.model.Data;
import br.com.vinicius.model.User;
import br.com.vinicius.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	User user;
	
	@Autowired
	Data data;

	@Override
	public User getUserInfo() {
		System.out.println(String.format("Data: %s", data) );

		return user;
	}

}
