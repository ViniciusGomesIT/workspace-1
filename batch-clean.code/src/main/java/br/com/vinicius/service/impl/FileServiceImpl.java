package br.com.vinicius.service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vinicius.entity.Person;
import br.com.vinicius.service.FileService;
import br.com.vinicius.util.DirectoryBuilder;
import br.com.vinicius.util.FileBuilder;
import br.com.vinicius.util.enums.FieldNameEnum;
import br.com.vinicius.util.enums.FieldTypeEnum;
import br.com.vinicius.util.enums.NameBatchEnum;

@Service("fileService")
public class FileServiceImpl implements FileService {
	
	@Autowired
	private PersonServiceImpl personService;

	@Override
	public void generatingFile(StringBuilder texto) {
		DirectoryBuilder geradorDiretorio = new DirectoryBuilder();
		FileBuilder geradorFile = new FileBuilder();

		geradorFile.fileWriter(texto.toString(),
				geradorDiretorio.createDirectory(NameBatchEnum.BATCH_EXTRACAO_USUARIOS.toString()));
	}

	//TODO tentar melhorar, diminuindo o tamanho
	@Override
	public StringBuilder formatingTextToExport() {
		StringBuilder textoFormatado = new StringBuilder();
		List<Person> listaPessoa = personService.findAllPersonInfo();
		Map<FieldNameEnum, Integer> tamanhoCampos = fillInFieldValues();
		
		if (!listaPessoa.isEmpty()) {
			listaPessoa.forEach(p -> {
				textoFormatado.append(formatingFields(p.getIdPessoa().toString(),
						tamanhoCampos.get(FieldNameEnum.CODIGO_PESSOA), FieldTypeEnum.NUMERICO));
				textoFormatado.append(formatingFields(p.getNomePessoa(),
						tamanhoCampos.get(FieldNameEnum.NOME_PESSOA), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(p.getCpf(), 
						tamanhoCampos.get(FieldNameEnum.CPF), FieldTypeEnum.NUMERICO));
				textoFormatado.append(formatingFields(p.getRg(), 
						tamanhoCampos.get(FieldNameEnum.RG), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(p.getDataNascimento().toString(),
						tamanhoCampos.get(FieldNameEnum.DATA_NASCIMENTO), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(p.getEndereco().getLogradouro(),
						tamanhoCampos.get(FieldNameEnum.LOGRADOURO), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(p.getEndereco().getComplemento(),
						tamanhoCampos.get(FieldNameEnum.COMPLEMENTO), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(String.valueOf(p.getEndereco().getNumero()),
						tamanhoCampos.get(FieldNameEnum.NUMERO), FieldTypeEnum.NUMERICO));
				textoFormatado.append(formatingFields(p.getEndereco().getBairro().getNomeBairro(),
						tamanhoCampos.get(FieldNameEnum.NOME_BAIRRO), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(p.getEndereco().getBairro().getCidade().getNomeCidade(),
						tamanhoCampos.get(FieldNameEnum.NOME_CIDADE), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(p.getEndereco().getBairro().getCidade().getEstado().getNomeEstado(),
						tamanhoCampos.get(FieldNameEnum.NOME_ESTADO), FieldTypeEnum.STRING));
				textoFormatado.append(formatingFields(p.getEndereco().getBairro().getCidade().getEstado().getSigla(),
						tamanhoCampos.get(FieldNameEnum.SIGLA_ESTADO), FieldTypeEnum.STRING));
				
				p.getListaVeic().forEach(veic -> {
					textoFormatado.append(formatingFields(veic.getModeloVeic(),
							tamanhoCampos.get(FieldNameEnum.MODELO_VEIC), FieldTypeEnum.STRING));
					textoFormatado.append(formatingFields(veic.getMarca().getNome(),
							tamanhoCampos.get(FieldNameEnum.NOME_MARCA_VEIC), FieldTypeEnum.STRING));
					textoFormatado.append(formatingFields(veic.getCor(),
							tamanhoCampos.get(FieldNameEnum.COR_VEIC), FieldTypeEnum.STRING));
					textoFormatado.append(formatingFields(veic.getCor(),
							tamanhoCampos.get(FieldNameEnum.COR_VEIC), FieldTypeEnum.STRING));
					textoFormatado.append(formatingFields(String.valueOf(veic.getAnoFabricacao()),
							tamanhoCampos.get(FieldNameEnum.ANO_FABRICACAO_VEIC), FieldTypeEnum.NUMERICO));
					textoFormatado.append(formatingFields(String.valueOf(veic.getAnoModelo()),
							tamanhoCampos.get(FieldNameEnum.ANO_MODELO_VEIC), FieldTypeEnum.NUMERICO));
				});
			});				

				textoFormatado.append("\n");
		}

		return textoFormatado;
	}
	
	@Override
	public String formatingFields(String text, int length, FieldTypeEnum type) {
		String campoFormatado = null;
		String spaceBetweenFields = " ";
		
		if (null == text || text.isEmpty()) {
			text = " ";
		}

		switch (type) {
		case NUMERICO:
			campoFormatado = String.format("%0" + length + "d", Long.valueOf(text)) + spaceBetweenFields;
			break;
		case STRING:
			campoFormatado = String.format("%-" + length + "s", text) + spaceBetweenFields;
			break;
		default:
			
		}

		if (text.length() > length) {
			campoFormatado = text.substring(0, length);
		}

		return campoFormatado;
	}

	@Override
	public Map<FieldNameEnum, Integer> fillInFieldValues() {
		Map<FieldNameEnum, Integer> tamanhoCampos = new HashMap<FieldNameEnum, Integer>();

		tamanhoCampos.put(FieldNameEnum.CODIGO_PESSOA, 10);
		tamanhoCampos.put(FieldNameEnum.NOME_PESSOA, 60);
		tamanhoCampos.put(FieldNameEnum.CPF, 14);
		tamanhoCampos.put(FieldNameEnum.RG, 7);
		tamanhoCampos.put(FieldNameEnum.DATA_NASCIMENTO, 10);
		tamanhoCampos.put(FieldNameEnum.LOGRADOURO, 60);
		tamanhoCampos.put(FieldNameEnum.COMPLEMENTO, 60);
		tamanhoCampos.put(FieldNameEnum.NUMERO, 5);
		tamanhoCampos.put(FieldNameEnum.NOME_BAIRRO, 60);
		tamanhoCampos.put(FieldNameEnum.NOME_CIDADE, 30);
		tamanhoCampos.put(FieldNameEnum.NOME_ESTADO, 30);
		tamanhoCampos.put(FieldNameEnum.SIGLA_ESTADO, 2);
		tamanhoCampos.put(FieldNameEnum.MODELO_VEIC, 30);
		tamanhoCampos.put(FieldNameEnum.ANO_FABRICACAO_VEIC, 4);
		tamanhoCampos.put(FieldNameEnum.ANO_MODELO_VEIC, 4);
		tamanhoCampos.put(FieldNameEnum.COR_VEIC, 15);
		tamanhoCampos.put(FieldNameEnum.NOME_MARCA_VEIC, 30);

		return tamanhoCampos;
	}
	
	//Method to read file and insert data in DB
	@Override
	public StringBuilder getFileContent(String nomeBatch) {
		try {
			//TODO extrair o método de leitura do arquivo para outro método
			String path = System.getProperty("user.dir") + "\\" + nomeBatch;
			StringBuilder inputText = new StringBuilder();
			FileReader fileReader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while (bufferedReader.readLine() != null) {
				inputText.append(bufferedReader.readLine());
				inputText.append("\n");
			}

			bufferedReader.close();
			
			return inputText;
		} catch (FileNotFoundException e) {			
			return new StringBuilder();
		} catch (IOException e) {
			return new StringBuilder();
		} 
	}
	
	@Override
	public StringBuilder formatingTextToImport(StringBuilder text) {		
		//TODO COMPLETAR LEITURA DO ARQUIVO DE ENTRADA PARA INSERÇÃO NA BASE;
		StringBuilder formatedText = new StringBuilder();
		
		return formatedText;
	}
}