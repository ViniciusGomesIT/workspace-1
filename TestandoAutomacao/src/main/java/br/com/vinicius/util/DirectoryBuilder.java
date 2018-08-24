package br.com.vinicius.util;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryBuilder {
	
	private String diretorio;

	public String CreateDirectory(String nomeTestes) {
		
		DateFormat formatadorData = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String dataAtual = formatadorData.format(new Date(System.currentTimeMillis()));
		
		diretorio = System.getProperty("user.dir") + "\\evidencias\\" + nomeTestes + "_" + dataAtual;
		
		File pasta = new File(diretorio);
		
		if (!pasta.exists()) {			
			pasta.mkdirs();			
		}
	
		return diretorio;
	}	

}
