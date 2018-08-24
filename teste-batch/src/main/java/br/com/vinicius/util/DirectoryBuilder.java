package br.com.vinicius.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryBuilder {
	
	private String diretorio;

	public String createDirectory(String nomeBatch) {
		
		DateFormat formatadorData = new SimpleDateFormat("dd-MM-yyyy");
		String dataAtual = formatadorData.format(new Date(System.currentTimeMillis()));
		
		diretorio = System.getProperty("user.dir") + "\\" + nomeBatch;
		
		File pasta = new File(diretorio);
		
		if (!pasta.exists()) {			
			pasta.mkdirs();			
		}
	
		return diretorio;
	}	

}
