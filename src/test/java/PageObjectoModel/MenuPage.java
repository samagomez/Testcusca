package PageObjectoModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.project.pom.Base;

public class MenuPage extends Base {

	public MenuPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By buttonClientes = By.xpath("//*[@id='clients']");
	By buttonUsuarios =By.xpath("//*[@id='users']");
	
	public Boolean IngresoCliente () throws InterruptedException {
		click(buttonClientes);
		return ObtieneBoolean(buttonClientes);

	}
	
	public Boolean IngresoUsuario () throws InterruptedException {
		Boolean valor=ObtieneBoolean(buttonUsuarios);
	    click(buttonUsuarios);
		return valor;
	}
	

}
