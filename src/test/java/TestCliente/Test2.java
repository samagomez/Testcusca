package TestCliente;

import org.testng.annotations.Test;
import PageObjectoModel.Clientepage;

import PageObjectoModel.LoginPage;
import TestForm.Testf;
import TestLogin.TestLogueo;
import TestMenu.Testm;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class Test2 {

	LoginPage loginpage;
	Clientepage ingresopage;
	
	String nombrebuscado="Leoncio Guardado Moran";
	String direccion ="san antonio molina";
	String correo ="cbasas@gmail.com";
	String telefono="72541265";
	String opcionMenu="Clientes";
	String nombreeditado="Llora";
	
	WebDriver driver;
	Testm tm =new Testm();
	Testf tf =new Testf();

	@BeforeClass
	@Parameters({"URL","BrowserType","Usr","pass"})
	public void beforeClass(String url,String browser,String Usr,String pass) throws InterruptedException  {
		TestLogueo t1 =new TestLogueo();
		driver=t1.beforeClass(url, browser);
		t1.pruebaLogin(Usr, pass);
		tm.testMenu(driver,opcionMenu);
		ingresopage= new Clientepage (driver);
		//formInsert= new FormInsertPage (driver);
		
	}	

	@Test(description="Caso de prueba logueo edicion",priority=2 )
	public void edicion() throws InterruptedException {

		
		//Assert.assertTrue(ingresopage.IngresoCliente (), "No se pudo loguear correctamente");
		Assert.assertTrue(ingresopage.BuscarCliente (nombrebuscado,1)!= 0, "No se encontro registro en la tabla");

	}

	@Test(description="Caso de prueba edicion y comprobar",priority=3 )
	public void edicionpart2() throws InterruptedException {
		
		tf.form(driver,2);
		//Assert.assertEquals(formInsert.editar(nombreeditado, direccion,correo,telefono),Validamsjeditar, "No se encontro mensaje de validacion");
			Assert.assertTrue(ingresopage.BuscarCliente (nombreeditado,1)!= 0, "No se encontro registro en la tabla");
	
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
