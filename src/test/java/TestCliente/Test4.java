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

public class Test4 {

	WebDriver driver;
	Clientepage ingresopage;
	String columnas[] = { "Nombre", "Direccion", "Telefono" };
	Testm tm =new Testm();
	String opcionMenu="Clientes";

	@BeforeClass
	@Parameters({"URL","BrowserType","Usr","pass"})
	public void beforeClass(String url,String browser,String Usr,String pass) throws InterruptedException {
		TestLogueo t1 =new TestLogueo();
		driver=t1.beforeClass(url, browser);
		t1.pruebaLogin(Usr, pass);
		tm.testMenu(driver,opcionMenu);
		ingresopage= new Clientepage (driver);

	}

	@Test(description = "Caso de prueba sort tabla", priority=6)
	public void sort() throws InterruptedException {

		//Assert.assertTrue(ingresopage.IngresoCliente(), "No se pudo loguear correctamente");
		for (int i = 0; i <= 2; i++) {
			Assert.assertTrue(ingresopage.ordenar(columnas[i]),"No se ordenaron correctamente los valores en la tabla de la columna " + columnas[i]);

		}

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
