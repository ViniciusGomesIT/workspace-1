package br.com.vinicius.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.vinicius.entity.Person;
import br.com.vinicius.entity.Vehicle;
import br.com.vinicius.util.DirectoryBuilder;
import br.com.vinicius.util.FileBuilder;
import br.com.vinicius.util.enums.NomeBatchEnum;
import br.com.vinicius.util.enums.NomeCampoEnum;
import br.com.vinicius.util.enums.TipoCampoEnum;

public class FileService {

	public FileService() {
	
	}

	public String formatingFields(String text, int length, TipoCampoEnum type) {
		String campoFormatado = null;
		if (null == text || text.isEmpty()) {
			text = " ";
		}

		switch (type) {
		case NUMERICO:
			campoFormatado = String.format("%0" + length + "d", Long.valueOf(text));
			break;
		case STRING:
			campoFormatado = String.format("%-" + length + "s", text);
			break;
		}

		if (text.length() > length) {
			campoFormatado = text.substring(0, length);
		}

		return campoFormatado;
	}

	public void generatingFile(StringBuilder texto) {
		DirectoryBuilder geradorDiretorio = new DirectoryBuilder();
		FileBuilder geradorFile = new FileBuilder();

		geradorFile.escrevendoArquivo(texto.toString(),
				geradorDiretorio.createDirectory(NomeBatchEnum.BATCH_EXTRACAO_USUARIOS.toString()));
	}

	public StringBuilder formatingTextToExport() {
		StringBuilder textoFormatado = new StringBuilder();
		List<Person> listaPessoa = new PersonService().findAllPersonInfo();
		Map<String, Integer> tamanhoCampos = fillInFieldValues();

		if (!listaPessoa.isEmpty()) {
			for (Person person : listaPessoa) {
				textoFormatado.append(formatingFields(person.getIdPessoa().toString(),
						tamanhoCampos.get(NomeCampoEnum.CODIGO_PESSOA.toString()), TipoCampoEnum.NUMERICO));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getNomePessoa(),
						tamanhoCampos.get(NomeCampoEnum.NOME_PESSOA.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getCpf(), tamanhoCampos.get(NomeCampoEnum.CPF.toString()),
						TipoCampoEnum.NUMERICO));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getRg(), tamanhoCampos.get(NomeCampoEnum.RG.toString()),
						TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getDataNascimento().toString(),
						tamanhoCampos.get(NomeCampoEnum.DATA_NASCIMENTO.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getEndereco().getLogradouro(),
						tamanhoCampos.get(NomeCampoEnum.LOGRADOURO.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getEndereco().getComplemento(),
						tamanhoCampos.get(NomeCampoEnum.COMPLEMENTO.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(String.valueOf(person.getEndereco().getNumero()),
						tamanhoCampos.get(NomeCampoEnum.NUMERO.toString()), TipoCampoEnum.NUMERICO));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getEndereco().getBairro().getNomeBairro(),
						tamanhoCampos.get(NomeCampoEnum.NOME_BAIRRO.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado.append(formatingFields(person.getEndereco().getBairro().getCidade().getNomeCidade(),
						tamanhoCampos.get(NomeCampoEnum.NOME_CIDADE.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado.append(
						formatingFields(person.getEndereco().getBairro().getCidade().getEstado().getNomeEstado(),
								tamanhoCampos.get(NomeCampoEnum.NOME_ESTADO.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");
				textoFormatado
						.append(formatingFields(person.getEndereco().getBairro().getCidade().getEstado().getSigla(),
								tamanhoCampos.get(NomeCampoEnum.SIGLA_ESTADO.toString()), TipoCampoEnum.STRING));
				textoFormatado.append(" ");

				for (Vehicle veic : person.getListaVeic()) {
					textoFormatado.append(formatingFields(veic.getModeloVeic(),
							tamanhoCampos.get(NomeCampoEnum.MODELO_VEIC.toString()), TipoCampoEnum.STRING));
					textoFormatado.append(" ");
					textoFormatado.append(formatingFields(veic.getMarca().getNome(),
							tamanhoCampos.get(NomeCampoEnum.NOME_MARCA_VEIC.toString()), TipoCampoEnum.STRING));
					textoFormatado.append(" ");
					textoFormatado.append(formatingFields(veic.getCor(),
							tamanhoCampos.get(NomeCampoEnum.COR_VEIC.toString()), TipoCampoEnum.STRING));
					textoFormatado.append(" ");
					textoFormatado.append(formatingFields(veic.getCor(),
							tamanhoCampos.get(NomeCampoEnum.COR_VEIC.toString()), TipoCampoEnum.STRING));
					textoFormatado.append(" ");
					textoFormatado.append(formatingFields(String.valueOf(veic.getAnoFabricacao()),
							tamanhoCampos.get(NomeCampoEnum.ANO_FABRICACAO_VEIC.toString()), TipoCampoEnum.NUMERICO));
					textoFormatado.append(" ");
					textoFormatado.append(formatingFields(String.valueOf(veic.getAnoModelo()),
							tamanhoCampos.get(NomeCampoEnum.ANO_MODELO_VEIC.toString()), TipoCampoEnum.NUMERICO));
					textoFormatado.append(" ");
				}

				textoFormatado.append("\n");
			}
		}

		return textoFormatado;
	}

	public Map<String, Integer> fillInFieldValues() {
		Map<String, Integer> tamanhoCampos = new HashMap<String, Integer>();

		tamanhoCampos.put(NomeCampoEnum.CODIGO_PESSOA.toString().toUpperCase(), 10);
		tamanhoCampos.put(NomeCampoEnum.NOME_PESSOA.toString().toUpperCase(), 60);
		tamanhoCampos.put(NomeCampoEnum.CPF.toString(), 14);
		tamanhoCampos.put(NomeCampoEnum.RG.toString(), 7);
		tamanhoCampos.put(NomeCampoEnum.DATA_NASCIMENTO.toString(), 10);
		tamanhoCampos.put(NomeCampoEnum.LOGRADOURO.toString().toUpperCase(), 60);
		tamanhoCampos.put(NomeCampoEnum.COMPLEMENTO.toString().toUpperCase(), 60);
		tamanhoCampos.put(NomeCampoEnum.NUMERO.toString(), 5);
		tamanhoCampos.put(NomeCampoEnum.NOME_BAIRRO.toString().toUpperCase(), 60);
		tamanhoCampos.put(NomeCampoEnum.NOME_CIDADE.toString().toUpperCase(), 30);
		tamanhoCampos.put(NomeCampoEnum.NOME_ESTADO.toString().toUpperCase(), 30);
		tamanhoCampos.put(NomeCampoEnum.SIGLA_ESTADO.toString().toUpperCase(), 2);
		tamanhoCampos.put(NomeCampoEnum.MODELO_VEIC.toString().toUpperCase(), 30);
		tamanhoCampos.put(NomeCampoEnum.ANO_FABRICACAO_VEIC.toString(), 4);
		tamanhoCampos.put(NomeCampoEnum.ANO_MODELO_VEIC.toString(), 4);
		tamanhoCampos.put(NomeCampoEnum.COR_VEIC.toString().toUpperCase(), 15);
		tamanhoCampos.put(NomeCampoEnum.NOME_MARCA_VEIC.toString().toUpperCase(), 30);

		return tamanhoCampos;
	}
	
	public StringBuilder getFileContent(String nomeBatch) {

		try {
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
			return null;
		} catch (IOException e) {
			return null;
		} 
	}
	
	public StringBuilder formatingTextToImport(StringBuilder text) {		
		//TODO COMPLETAR LEITURA DO ARQUIVO DE ENTRADA PARA INSERÇÃO NA BASE;
		StringBuilder formatedText = new StringBuilder();
		
		return formatedText;
	}
}