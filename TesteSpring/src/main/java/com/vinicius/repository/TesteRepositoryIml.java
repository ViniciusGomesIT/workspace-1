package com.vinicius.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository("testeRepository")
public class TesteRepositoryIml implements TesteRepository {
	
	@Value("${dbUsername}")
	private String userName;
	
	@Value("${dbPassword}")
	private String password;
	
	@Value("${urlPath}")
	private String path;

	public void insertOrUpdate() {
		System.out.println(userName + " " + password + " " + path);
	}
}
