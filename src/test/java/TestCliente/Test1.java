package TestCliente;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjectoModel.Clientepage;
import PageObjectoModel.FormInsertPage;
import PageObjectoModel.LoginPage;
import PageObjectoModel.MenuPage;
import TestForm.Testf;
import TestLogin.TestLogueo;
import TestMenu.Testm;


public class Test1 {
	/*
	String mensajes[]=null;
	String nombre="Leoncio Guardado Moran";
	String direccion ="san antonio";
	String correo ="cb@gmail.com";
	String telefono="72341265";
	*/
	String nombre="Leoncio Guardado Moran";
	String opcionMenu="Clientes";
	MenuPage menu;
	Clientepage ingresopage;
	LoginPage loginpage;
	FormInsertPage formInsert;
	WebDriver driver;
	//WebDriver driver2;
	
	Testf tf = new Testf();
	TestLogueo t1 =new TestLogueo();
	Testm tm =new Testm();
	
	@BeforeClass
	@Parameters({"URL","BrowserType","Usr","pass"})
	public void Login(String url,String browser,String Usr,String pass) throws InterruptedException {

		//TestLogueo t1 =new TestLogueo();
		//Testm tm =new Testm();
		driver=t1.beforeClass(url, browser);
		t1.pruebaLogin(Usr, pass);
		tm.testMenu(driver,opcionMenu);
		ingresopage= new Clientepage (driver);
		formInsert= new FormInsertPage (driver);
	}

	
	@AfterMethod
	public void AfterMethod(ITestResult result) {
		
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


	@Test(description="Caso de prueba Logueo", priority=1)
	public void prueba() throws InterruptedException {
		
		tf.form(this.driver, 1);
		Assert.assertTrue(ingresopage.BuscarCliente (nombre,1)!= 0, "No se encontro registro en la tabla");

		}



	@AfterClass
	public void closeBrowser(){
		driver.close();
		
		
	}
	



}
