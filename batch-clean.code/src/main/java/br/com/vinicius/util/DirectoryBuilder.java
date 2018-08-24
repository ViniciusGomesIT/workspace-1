package br.com.vinicius.util;

import java.io.File;

public class DirectoryBuilder {
	
	public String createDirectory(String batchName) {		
		String directory = System.getProperty("user.dir") + "\\" + batchName;		
		File folder = new File(directory);
		
		if (!folder.exists()) {			
			folder.mkdirs();			
		}
	
		return directory;		
	}	
}