package br.com.vinicius.util;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfigure {

	private WebDriver driver = null;

	public WebDriver configureWebDriver(String nomeNavegador) {

		try {

			if ("chrome".equalsIgnoreCase(nomeNavegador)) {
				Runtime.getRuntime().exec("taskkill /IM chrome.exe");

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromeDriver.exe");
				this.driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				return this.driver;

			} else if ("mozilla".equalsIgnoreCase(nomeNavegador) || "firefox".equalsIgnoreCase(nomeNavegador)) {
				Runtime.getRuntime().exec("taskkill /IM mozilla.exe");

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/geckoDriver.exe");
				this.driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				return this.driver;

			} else if ("edge".equalsIgnoreCase(nomeNavegador) || "ie".equalsIgnoreCase(nomeNavegador)) {
				Runtime.getRuntime().exec("taskkill /IM edge.exe");

				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "/drivers/edgeDriver.exe");
				this.driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

				return this.driver;

			} else {
				return null;
			}

		} catch (IOException e) {
			throw new RuntimeException("Não foi possível encerrar a thread do navegador" + e);
		}

	}

}
