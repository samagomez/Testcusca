package TestLogin;

import org.testng.annotations.Test;

import com.project.pom.DriverInit;

import PageObjectoModel.Clientepage;
import PageObjectoModel.LoginPage;
//import PageObjectoModel.UsuarioPage;
//import TestCliente.Test1;


import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TestLogueo {
	
	
	WebDriver driver;	
	LoginPage loginp;
	//Clientepage ingresopage;
	

	
	@BeforeClass
	@Parameters({"URL","BrowserType"})
	public WebDriver beforeClass(String url,String browser) throws InterruptedException  {
		driver=null;
		driver =DriverInit.getInstance(browser).getDriver();
		//ingresopage= new Clientepage (driver);
		loginp= new LoginPage (driver);
		//ingresopage.direccionar(url);
		loginp.direccionar(url);
		return driver;
			
	}
		
	
  @Test (description="Caso de prueba Logueo")
  @Parameters({"Usr","pass"})
 /*
  public void pruebaLogin(String Usr,String pass) throws InterruptedException {	
	  loginp.login(Usr, pass);
	  
  }
  */
  
	@AfterMethod
	/*public void afterTest(ITestResult result) {
		String status="";
		if(result.getStatus()==1){
			status="Exitosamente";
		}
		else{

			status="con inconvenientes";
		}
		System.out.println("El "+result.getMethod().getDescription()+" fue ejecutado "+status);
		System.out.println("Test Case Finalizado..");
	}
	*/
	@AfterClass
	public void CloseBrowser() {
		
		//driver.close();
	}

}
