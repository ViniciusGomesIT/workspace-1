package com.vinicius.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vinicius.repository.TesteRepositoryIml;

@Service("testeService")
public class TesteService {

	@Autowired
	TesteRepositoryIml testeRepository;
	
	public void insertOrUpdate() {
		testeRepository.insertOrUpdate();
	}
}
