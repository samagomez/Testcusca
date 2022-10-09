package TestMenu;

import org.testng.annotations.Test;
import PageObjectoModel.LoginPage;
import PageObjectoModel.MenuPage;
import TestLogin.TestLogueo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Testm {
	WebDriver driver;
	LoginPage loginp;
    MenuPage menu;
    
	
	  @BeforeClass
		@Parameters({"URL","BrowserType","Usr","pass"})
		public void Login(String url,String browser,String Usr,String pass) throws InterruptedException {

			
			TestLogueo t1 =new TestLogueo();
			driver=t1.beforeClass(url, browser);
			t1.pruebaLogin(Usr, pass);
			menu= new MenuPage (driver);

		}

	  @Test(description="Caso de prueba Logueo")
  public void testMenu() throws InterruptedException {
			
		  Assert.assertTrue(menu.IngresoCliente (), "No se pudo loguear correctamente");
		  Assert.assertTrue(menu.IngresoUsuario (), "No se pudo loguear correctamente");
		
  }  
	  
	  @Test(description="Caso de prueba Logueo", enabled=false)
  public void testMenu(WebDriver driver,String opcionMenu) throws InterruptedException {
			menu= new MenuPage (driver);
			
		if(opcionMenu.equalsIgnoreCase("Clientes")	){
		  Assert.assertTrue(menu.IngresoCliente (), "No se pudo loguear correctamente");
		}
		else {
			Assert.assertTrue(menu.IngresoUsuario(), "No se pudo loguear correctamente");
		}
		
  }
  @AfterMethod
  public void afterMethod() {
  }



  @AfterClass
  public void afterClass() {
  }

}
