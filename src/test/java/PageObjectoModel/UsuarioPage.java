package PageObjectoModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.project.pom.Base;


public class UsuarioPage extends Base {

	//By buttonUsuarios =By.xpath("//*[@id='users']");
	By btnUsernew = By.id("btnNew");
	By txtnombre =By.id("txtName");
	By txtapellido = By.id("txtLastName");
	By txtcorreo = By.id("txtUserEmail");
	By txtpass = By.id("txtPassword");
	By txtpassr = By.id("txtPassword1");
	By buttonInUsuario= By.cssSelector("button[type='submit']"); 
	By msjValidacion= By.xpath("/html/body/div[2]");    
	By  buttonEditar = By.cssSelector("button[title='Editar']");
	By msjValidanombre =By.id("txtName-error");
	By msjValidaapellido =By.id("txtLastName-error");
	By msjValidacorreo =By.id("txtUserEmail-error");
	By msjValidapass =By.id("txtPassword-error");
	By msjValidapassr =By.id("txtPassword1-error");

	public UsuarioPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
/*
	public Boolean IngresoUsuario () throws InterruptedException {
		Boolean valor=ObtieneBoolean(buttonUsuarios);
	    click(buttonUsuarios);
		return valor;
	}
*/
	public void AgregaUsuario () throws InterruptedException {
		click(btnUsernew);	

	}

	public String [] ValidacampoUser () throws InterruptedException {

		click(buttonInUsuario);
		String mensajes[]={obtienetexto(msjValidanombre),obtienetexto(msjValidaapellido),obtienetexto(msjValidacorreo),obtienetexto(msjValidapass),obtienetexto(msjValidapassr)};
		return mensajes;
		
	}


	public String IngresarUsuario (String nombre,String apellido,String correo,String pass,String passr) throws InterruptedException {
		llenarCampo(txtnombre, nombre);
		llenarCampo(txtapellido,apellido);
		llenarCampo(txtcorreo,correo);
		llenarCampo(txtpass,pass);
		llenarCampo(txtpassr,passr);
		click(buttonInUsuario);
		
		return obtienetexto(msjValidacion);
		
	}

	public String editar (String nombre, String apellido) throws InterruptedException {

		click(buttonEditar);
		llenarCampo(txtnombre,nombre);
		llenarCampo(txtapellido,apellido);
		
		click(buttonInUsuario);

		return obtienetexto(msjValidacion);
	}

}
