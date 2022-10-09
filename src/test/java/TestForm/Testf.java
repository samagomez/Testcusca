package TestForm;

import org.testng.annotations.Test;
import PageObjectoModel.FormInsertPage;
import TestLogin.TestLogueo;
import TestMenu.Testm;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Testf {
WebDriver driver;
String opcionMenu="Clientes";
FormInsertPage Forminsert;
String nombreeditado="Llora";
String mensajes[]=null;
String nombre="Leoncio Guardado Moran";
String  Validamsjeditar="El registro se actualizó correctamente";
String direccion ="san antonio";
String correo ="cb@gmail.com";
String telefono="72341265";
	
 
  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
	@Parameters({"URL","BrowserType","Usr","pass"})
	public void Loginmenu(String url,String browser,String Usr,String pass) throws InterruptedException {

		TestLogueo t1 =new TestLogueo();
		Testm tm =new Testm();
		driver=t1.beforeClass(url, browser);
		t1.pruebaLogin(Usr, pass);
		tm.testMenu(driver,opcionMenu);
		Forminsert= new FormInsertPage (driver);

	}
  
  @Test(description="Caso de prueba ingreso", enabled=false)
  public void form(WebDriver driver, int edita) throws InterruptedException {
	  Forminsert= new FormInsertPage (driver);
	  
	  if (edita==1){
	  String mensajes[]=Forminsert.validaCamposClientes ();
	  
		for(int i=0;i<=3;i++){
			Assert.assertEquals(mensajes[i],"El campo es obligatorio" ,"los campos Nombre,Direccion ,correo y telefono son obligatorios");	
		}
		Assert.assertEquals(Forminsert.agregaCliente (nombre,direccion,correo, telefono),"El registro se guardo correctamente", "No se encontro mensaje de validacion");
		
	  }
	  
	  else{
		  Assert.assertEquals(Forminsert.editar(nombreeditado, direccion,correo,telefono),Validamsjeditar, "No se encontro mensaje de validacion");
	  }
	  
  }
  
  @Test(description="Caso de prueba ingreso sin parametro")
  public void form() throws InterruptedException {

	  String mensajes[]=Forminsert.validaCamposClientes ();
		for(int i=0;i<=3;i++){
			Assert.assertEquals(mensajes[i],"El campo es obligatorio" ,"los campos Nombre,Direccion ,correo y telefono son obligatorios");	
		}
		Assert.assertEquals(Forminsert.agregaCliente (nombre,direccion,correo, telefono),"El registro se guardo correctamente", "No se encontro mensaje de validacion");
		Thread.sleep(2000);
		Assert.assertEquals(Forminsert.editar(nombreeditado, direccion,correo,telefono),Validamsjeditar, "No se encontro mensaje de validacion");
  }
  
  @AfterClass
  public void afterClass() {
  }

}
