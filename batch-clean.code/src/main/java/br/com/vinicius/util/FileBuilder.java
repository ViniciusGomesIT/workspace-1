package br.com.vinicius.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.vinicius.util.enums.NameBatchEnum;

public class FileBuilder {	
	
	DirectoryBuilder directoryBuilder;	
	
	public FileBuilder() {
		this.directoryBuilder = new DirectoryBuilder();
	}

	public void fileWriter(String message, String path) {	
		File file = null;
		
		try {			
			String data = new SimpleDateFormat("ddMMyyyy").format(new Date(System.currentTimeMillis()));
					
			file = new File(path 
							  + "\\"
							  + NameBatchEnum.BATCH_EXTRACAO_USUARIOS.toString().toLowerCase() 
							  + "_"
							  + data
							  + ".txt");	
			
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
			
			bufferedWriter.write(message);
			bufferedWriter.flush();
			bufferedWriter.close();					
			
		} catch (IOException e) {
			throw new RuntimeException("Houve um problema na gravação do arquivo" + e.getMessage());			
		} 
	}
}
