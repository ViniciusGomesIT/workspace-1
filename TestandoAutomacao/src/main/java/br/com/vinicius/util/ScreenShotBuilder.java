package br.com.vinicius.util;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenShotBuilder {
	
	int contador = 0;

	public void obtendoScreenShot(String path) {    
        
        try {        	
    		String diretorio = path
    				+ "/screenshots/";

    		File arquivoChecar = new File(diretorio);	
    		
    		if (!arquivoChecar.exists()) {
    			arquivoChecar.mkdirs();
    		}		
        	    		   		
        	BufferedImage buferredImage = new Robot().createScreenCapture(new Rectangle(
        			Toolkit.getDefaultToolkit().getScreenSize().width, 
        			Toolkit.getDefaultToolkit().getScreenSize().height));        	
			ImageIO.write(buferredImage, "jpg", new File(diretorio + "evidence" + contador +".jpg"));			
			contador++;
			
		} catch (IOException e) {
			throw new RuntimeException("Não foi possível salvar a captura de tela. " + e);
			
		} catch (HeadlessException e) {
			throw new RuntimeException("Não foi possível gerar o print da tela." + e);			
		} catch (AWTException e) {
			throw new RuntimeException("Não foi possível gerar o print da tela." + e);
		}
        
	}
}
