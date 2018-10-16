package br.com.vinicius.controller;

import org.springframework.http.ResponseEntity;

import br.com.vinicius.model.User;

public interface UserResources {

	ResponseEntity<User> getUserInfo();
}
