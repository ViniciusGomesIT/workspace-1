package br.com.vinicius.test;

import br.com.vinicius.objects.Objects;
import br.com.vinicius.util.DirectoryBuilder;
import br.com.vinicius.util.LogBuilder;
import br.com.vinicius.util.ScreenShotBuilder;

public class TestandoSiteCorreiosRastreamentoInvalido {

	public static void main(String[] args) {
		try {
		//Setup
		String diretorio = new DirectoryBuilder().CreateDirectory("TestandoSiteCorreiosRastreamentoInvalido");
		LogBuilder log = new LogBuilder();
		ScreenShotBuilder print = new ScreenShotBuilder();
		Objects objetos = new Objects();
		
		//Starting test
		log.escrevendoLog("---- Iniciando o teste ----", diretorio);
		
		objetos.wait(4);
		
		objetos.openingURL("http://www.correios.com.br");	
		
		objetos.wait(4);
		
		log.escrevendoLog("Link alcançado com sucesso", diretorio);
		print.obtendoScreenShot(diretorio);
		
		objetos.findElementByXpath("//*[@id='content-principais-servicos']/ul/li[2]/a/img").click();
		
		objetos.wait(4);
		
		log.escrevendoLog("Menu rastreamento alcançado com sucesso", diretorio);
		print.obtendoScreenShot(diretorio);
		
		objetos.findElementByXpath("//*[@id='objetos']").sendKeys("AA999999999BR");
		print.obtendoScreenShot(diretorio);
		objetos.findElementByXpath("//*[@id='btnPesq']").click();
		
		objetos.wait(4);
		
		log.escrevendoLog("Consultando o dado informado", diretorio);
		
		String texto = objetos.findElementByXpath("/html/body/div[1]/div[3]/div[2]/div/div/div[2]/div[2]/div[1]").getText();
		
		if (texto.contains("O nosso sistema não possui dados sobre o objeto informado")) {
			log.escrevendoLog("Dado encontrado com sucesso", diretorio);
		} else {
			log.escrevendoLog("O dado não foi encontrado", diretorio);
		}
		
		print.obtendoScreenShot(diretorio);
		log.escrevendoLog("---- Encerrando o teste ----", diretorio);
		objetos.closingBrowser();
		
		} catch (InterruptedException e) {
			throw new RuntimeException("Problema ao pausar a thread" + e);
		}
	}

}
