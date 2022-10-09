package PageObjectoModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.project.pom.Base;


public class FormInsertPage extends Base {
	
	By btnClientenew = By.id("btnNew");
	By btnClnsave=  By.id("save");
	By msjValidanombre =By.id("txtClientName-error");
	By msjValidadireccion=By.id("txtAddress-error");
	By msjValidacorreo=By.id("txtClientEmail-error");
	By msjValidatelefono=By.id("txtPhone-error");
	By Textonombre= By.id("txtClientName");
	By Textodireccion= By.id("txtAddress");
	By Textocorreo= By.id("txtClientEmail");
	By Textotelefono= By.id("txtPhone");
	By mensahe=By.xpath("/html/body/div[2]");
	By  buttonEditar = By.cssSelector("button[title='Editar']");

	public FormInsertPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String [] validaCamposClientes () throws InterruptedException {

		
		click(btnClientenew);
		click(btnClnsave);
		String mensajes[]={obtienetexto(msjValidanombre),obtienetexto(msjValidadireccion),obtienetexto(msjValidacorreo),obtienetexto(msjValidatelefono)};
		return mensajes;
	}


	public String agregaCliente (String Nombre, String Direccion, String Correo, String Telefono) throws InterruptedException {

		llenarCampo(Textonombre,Nombre);
		llenarCampo(Textodireccion,Direccion);
		llenarCampo(Textocorreo,Correo);
		llenarCampo(Textotelefono,Telefono);
		click(btnClnsave);
		return obtienetexto(mensahe);
	}
	
	
	public String editar (String Nombre, String Direccion, String Correo, String Telefono) throws InterruptedException {

		click(buttonEditar);
		llenarCampo(Textonombre,Nombre);
		llenarCampo(Textodireccion,Direccion);
		llenarCampo(Textocorreo,Correo);
		llenarCampo(Textotelefono,Telefono);
		click(btnClnsave);
		return obtienetexto(mensahe);
	}

}
