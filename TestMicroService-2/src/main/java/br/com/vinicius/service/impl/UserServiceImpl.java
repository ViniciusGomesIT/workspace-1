package br.com.vinicius.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.vinicius.model.Data;
import br.com.vinicius.model.User;
import br.com.vinicius.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private User user;
	private Data data;

	@Inject
	public UserServiceImpl(User user, Data data) {
		this.user = user;
		this.data = data;
	}

	@Override
	public User getUserInfo() {
		System.out.println(String.format("Data: %s", data) );
		System.out.println(String.format("User: %s", user));

		return user;
	}

}
