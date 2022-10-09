package PageObjectoModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.project.pom.Base;

public class LoginPage extends Base {
	
	By campoCorreo =By.id("txtUserEmail");
	By campoPass =By.id("txtPassword");
	By button = By.xpath("//*[@id='loginForm']/div[4]/button");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void login (String user, String pass) throws InterruptedException {

		llenarCampo(campoCorreo,user);
		llenarCampo(campoPass,pass);
		click(button);


	}

}
