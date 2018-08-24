package br.com.vinicius.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogBuilder {	
	
	DirectoryBuilder directoryBuilder = new DirectoryBuilder();	
	File pasta = null;
	File arquivo = null;
	int contador = 0;
	
	public void escrevendoLog(String mensagem, String path) {	
		
		try {
			
			String diretorio = path	+ "\\log\\";						
	
			pasta = new File(diretorio);
			
			if (!pasta.exists()) {
				pasta.mkdirs();				
			}
			
			arquivo = new File(diretorio + "logExecution.txt");			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo, true));
			
			if (contador == 0) {
				bufferedWriter.write("---- Iniciando o teste ----");
				bufferedWriter.newLine();
				contador ++;
				
			} else if (mensagem.toLowerCase().contains("encerrando") 
						|| mensagem.contains("final")) {
				bufferedWriter.write("---- Final do teste ----");				
				
			} else {
				bufferedWriter.write("[STEP" + contador + "] " + mensagem);
				bufferedWriter.newLine();
				contador++;
			}				
			
			bufferedWriter.flush();
			bufferedWriter.close();					
			
		} catch (IOException e) {
			throw new RuntimeException("N�o foi poss�vel escrever no arquivo informado." + e);
			
		} 
	}
}
