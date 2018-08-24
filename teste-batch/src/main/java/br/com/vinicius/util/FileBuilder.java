package br.com.vinicius.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.vinicius.util.enums.NomeBatchEnum;

public class FileBuilder {	
	
	DirectoryBuilder directoryBuilder;	
	File pasta = null;
	File arquivo = null;
	
	public FileBuilder() {
		this.directoryBuilder = new DirectoryBuilder();
	}

	public void escrevendoArquivo(String mensagem, String path) {			
		try {
			
			pasta = new File(path);
			String data = new SimpleDateFormat("ddMMyyyy").format(new Date(System.currentTimeMillis())).toString();
			
			if (!pasta.exists()) {
				pasta.mkdirs();				
			}
			
			arquivo = new File(path 
							  + "\\"
							  + NomeBatchEnum.BATCH_EXTRACAO_USUARIOS.toString().toLowerCase() 
							  + "_"
							  + data
							  + ".txt");	
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(arquivo, false));
			
			bufferedWriter.write(mensagem);
			bufferedWriter.flush();
			bufferedWriter.close();					
			
		} catch (IOException e) {
			throw new RuntimeException("Houve um problema na geração do arquivo" + e.getMessage());
			
		} 
	}
}
