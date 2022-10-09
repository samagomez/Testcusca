package TestCliente;

import org.testng.annotations.Test;
import PageObjectoModel.Clientepage;
import TestLogin.TestLogueo;
import TestMenu.Testm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Test5 {
	WebDriver driver;
	Clientepage ingresopage;
	Testm tm =new Testm();
	String opcionMenu="Clientes";
		
  @Test(description="Caso de prueba mostrar n registros en tabla", priority=7)
  public void filtros() throws InterruptedException {
		String mensajes[]={"10","25","50","100"};
		Integer mensajesint[]={10,25,50,100};
		
		//Assert.assertTrue(ingresopage.IngresoCliente (), "No se pudo loguear correctamente");
		for(int i=0;i<=3;i++){
	
			Assert.assertTrue(ingresopage.registros(mensajes[i])<=mensajesint[i], "No se muestran correctamente la cantidad de registros requeridos");
				
		}

	  
  }
	@BeforeClass
	@Parameters({"URL","BrowserType","Usr","pass"})
	public void beforeClass(String url,String browser,String Usr,String pass) throws InterruptedException {
		TestLogueo t1 =new TestLogueo();
		driver=t1.beforeClass(url, browser);
		t1.pruebaLogin(Usr, pass);
		tm.testMenu(driver,opcionMenu);
		ingresopage= new Clientepage (driver);

	}

	@AfterMethod
	public void afterTest(ITestResult result) {
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
	
	@AfterClass
	public void CloseBrowser() {
		driver.close();
	}

}
