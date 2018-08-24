package br.com.vinicius.service;

import java.util.Map;

import br.com.vinicius.util.enums.FieldNameEnum;
import br.com.vinicius.util.enums.FieldTypeEnum;

public interface FileService {

	void generatingFile(StringBuilder texto);

	//TODO tentar melhorar, diminuindo o tamanho
	StringBuilder formatingTextToExport();

	String formatingFields(String text, int length, FieldTypeEnum type);

	Map<FieldNameEnum, Integer> fillInFieldValues();

	//Method to read file and insert data in DB
	StringBuilder getFileContent(String nomeBatch);

	StringBuilder formatingTextToImport(StringBuilder text);

}