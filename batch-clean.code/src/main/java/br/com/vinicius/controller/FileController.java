package br.com.vinicius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.vinicius.service.FileService;

@Component("fileController")
public class FileController {

	@Autowired
	private FileService service;

	public void generatingFile() {
		service.generatingFile(this.service.formatingTextToExport());
	}
}
