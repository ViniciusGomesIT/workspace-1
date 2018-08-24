package br.com.vinicius.controller;

import br.com.vinicius.service.FileService;

public class FileController {

	private FileService service;

	public FileController() {
		this.service = new FileService();
	}

	public void generatingFile() {
		service.generatingFile(this.service.formatingTextToExport());
	}
}
