package br.com.vinicius.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.vinicius.util.WebDriverConfigure;

public class Objects {
	
	WebDriver driver = new WebDriverConfigure().configureWebDriver("chrome");	
	
	public void closingBrowser() {
		this.driver.close();
	}
	
	public void openingURL(String Url) {		
		this.driver.get(Url);
	}
	
	public WebElement findElementById(String id) {				
		return driver.findElement(By.id(id));		
	}
	
	public WebElement findElementByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	
	public WebElement findElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}
	
	public List<WebElement> findElementsById(String id) {
		return driver.findElements(By.id(id));
	}
	
	public List<WebElement> findElementsByTagName(String tagName) {
		return driver.findElements(By.tagName(tagName));
	}
	
	@SuppressWarnings("static-access")
	public void wait(int timeToWaitInSeconds) throws InterruptedException {
		Thread.currentThread().sleep(timeToWaitInSeconds * 1000);
	}	

}