
package TestCliente;

import org.testng.annotations.Test;
import PageObjectoModel.Clientepage;
import TestLogin.TestLogueo;
import TestMenu.Testm;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;


public class Test3 {

	WebDriver driver;
	Clientepage ingresopage;
	String nombre="Llora";
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


	@Test(description="Caso de prueba ingresa a interfaz de eliminacion" ,priority=4)
	public void eliminacion() throws InterruptedException {

		//Assert.assertTrue(ingresopage.IngresoCliente (), "No se pudo loguear correctamente");

	}


	@Test(description="Caso de prueba eliminacion de cliente" ,priority=5)
	public void eliminacionpt2() throws InterruptedException {

		Assert.assertTrue(ingresopage.BuscarCliente (nombre,1)!= 0, "No se encontro registro en la tabla");
		Assert.assertEquals(ingresopage.Eliminar (),"El registro se elimino correctamente", "No se encontro mensaje de validacion");
		Assert.assertFalse(ingresopage.BuscarCliente(nombre,0)!= 0, "No se encontro registro en la tabla");
		
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
