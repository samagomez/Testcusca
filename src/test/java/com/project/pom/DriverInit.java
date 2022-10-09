package com.project.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverInit {

	public WebDriver driver;
	private static DriverInit driverInit = null;

	public static DriverInit getInstance(String valor) {
		//if (driverInit == null) {
			driverInit = new DriverInit(valor);
		//}
		return driverInit;
	}

	public DriverInit(String valor) {
		
		if(valor.equalsIgnoreCase("Chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SALVADOR\\Desktop\\udemy\\seleniumUDEMY\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
	
		else if(valor.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver", "./src/test/resources/IEDriverServer_Win32/IEDriverServer.exe");
			this.driver = new InternetExplorerDriver();
			this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
			
		}
		
		else{
			System.setProperty("webdriver.gecko.driver", "./src/test/resources/geckodriver/geckodriver.exe");
			this.driver = new FirefoxDriver();
			this.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
			
		}

	}

	public WebDriver getDriver() {
		return this.driver;
	}


}
