package com.project.pom;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

	private WebDriver driver;

	String texto="";
	Boolean valor ;
	int valor2 ;

	public  Base (WebDriver driver){
		this.driver=driver;
	}



	public  WebElement findElement(By locator){

		return driver.findElement(locator);
	}


	public  Boolean findElements(By locator) throws InterruptedException{

		Thread.sleep(2000);
		List<WebElement> elementList=null;
		List<String> originalList=null;
		List<String> sortedList =null;
		elementList = driver.findElements(locator);//Obtiene los valores de la tabla
		originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());//convierte a String los valores de la columna
		sortedList = originalList.stream().sorted().collect(Collectors.toList());//ordena los valores de la lista
		return originalList.equals(sortedList);
	}



	public  void llenarCampo(By locator,String mensaje) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(mensaje);


	}

	public  void direccionar(String url){

		driver.get(url);
	}

	public  void click(By locator) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,10);

		driver.switchTo().activeElement();
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
		driver.switchTo().activeElement();

	}

	public  String obtienetexto(By locator) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver,10);

		driver.switchTo().activeElement();
		//texto=
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	public  Boolean ObtieneBoolean(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,10);

		//valor = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();


	}



	public  int ObtieneExistencia(By locator) {

		//valor2 = driver.findElements(locator).size();
		return driver.findElements(locator).size();


	}

	public  void Obtienevalor(By locator,String cantidad) {
		WebDriverWait wait = new WebDriverWait(driver,10);


		WebElement	staticdropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByValue(cantidad);


	}

	public  int ObtieneColumna(By locator) {

		//int tamaño;
		List<WebElement> elementList = driver.findElements(locator);//Obtiene los valores de la tabla
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());//convierte a String los valores de la columna
		//tamaño=originalList.size();
		return 	originalList.size();
	}



}






