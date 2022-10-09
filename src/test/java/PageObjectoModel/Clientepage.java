package PageObjectoModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.project.pom.Base;



public class Clientepage extends Base {

	//By buttonClientes = By.xpath("//*[@id='clients']");
	/*
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
	*/
	By mensahe=By.xpath("/html/body/div[2]");
	
	By TextoBuscar= By.cssSelector("input[type='search']");
	
	//By  buttonEditar = By.cssSelector("button[title='Editar']");
	By  buttonEliminar = By.cssSelector("button[title='Eliminar']");
	By  buttonConfirmaElimina = By.cssSelector("button[data-bb-handler='confirm']"); 
	By Textovalida=By.cssSelector("td[class='dataTables_empty']");
	By columnaNombre= By.xpath("//th[contains(text(),'Nombre')]");
	By columnanombrecompleta= By.xpath("//tbody/tr/td[2]");
	By columnaDireccion= By.xpath("//th[contains(text(),'Dirección')]");
	By columnadireccioncompleta= By.xpath("//tbody/tr/td[3]");
	By columnacorreo= By.xpath("//th[contains(text(),'Correo')]");
	By columnacorreocompleta= By.xpath("//tbody/tr/td[4]");
	By columnatelefono= By.xpath("//th[contains(text(),'Teléfono')]");
	By columnatelefonocompleta= By.xpath("//tbody/tr/td[5]");
	By Mostrarregistros=By.cssSelector("select[name='clientGrid_length']");

	public Clientepage(WebDriver driver) {
		super(driver);

	}

/*
	public Boolean IngresoCliente () throws InterruptedException {
		click(buttonClientes);
		return ObtieneBoolean(buttonClientes);

	}
*/ 
	/*
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
*/
	public int BuscarCliente (String nombre,int funcion) throws InterruptedException {
		int valorB=0;
		llenarCampo(TextoBuscar,nombre);
		if(funcion==1){
			valorB=ObtieneExistencia(Textovalida);

		}

		if(ObtieneExistencia(Textovalida)!= 0){
			System.out.println("No se ingreso registro o fue eliminado");			
		}

		else{
			System.out.println("se confirma que registro fue Ingresado/Editado o eliminado correctamente");
			valorB=1;
		}

		return valorB;
	}

	
	//public String editar (String Nombre, String Direccion, String Correo, String Telefono) throws InterruptedException {

		//click(buttonEditar);
		//llenarCampo(Textonombre,Nombre);
		//llenarCampo(Textodireccion,Direccion);
		//llenarCampo(Textocorreo,Correo);
		//llenarCampo(Textotelefono,Telefono);
		//click(btnClnsave);
		//return obtienetexto();
	//}
	

	
	public String Eliminar () throws InterruptedException  {

		click(buttonEliminar);
		click(buttonConfirmaElimina);
		return obtienetexto(mensahe);
	}


	public Boolean ordenar (String columna) throws InterruptedException  {
		Thread.sleep(2000);

		Boolean valor=false;
		String opcioncolumna = "";
		opcioncolumna = columna;

		switch (opcioncolumna) 
		{
		case "Nombre":  
			click(columnaNombre);
			valor=findElements(columnanombrecompleta);
			break;
		case "Direccion":  
			click(columnaDireccion);
			valor=findElements(columnadireccioncompleta);
			break;

		case "Correo":  
			click(columnacorreo);
			valor=findElements(columnacorreocompleta);
			break;         

		case "Telefono":  
			click(columnatelefono);
			valor=findElements(columnatelefonocompleta);
			break; 

		}

		return valor;

	}


	public int registros (String cantidad ) throws InterruptedException  {
		
		Thread.sleep(2000);
		click(Mostrarregistros);
		Obtienevalor(Mostrarregistros,cantidad);
		Thread.sleep(2000);
		
		return ObtieneColumna(columnanombrecompleta);

	}

}



