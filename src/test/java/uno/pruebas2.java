package uno;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class pruebas2 {



		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SALVADOR\\Desktop\\udemy\\seleniumUDEMY\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			WebDriverWait wait = new WebDriverWait(driver,10);
			
			double setrate=0.0;
			
			double homePrice=250000;
			boolean activeButttonpercent=true;
			double Percent=20;
			String loanterm="30 Years";
			double interesrate=4;
			double Amount=50000;
			double Mvalue=0.0;
		
		
			driver.get("https://www.rocketmortgage.com/calculators/mortgage-calculator?qlsource=RMTextLink");
			driver.findElement(By.id("purchasePrice")).clear();
			driver.findElement(By.id("purchasePrice")).sendKeys(""+homePrice);
			if(activeButttonpercent)
			{
				
				driver.findElement(By.id("buttonPercent")).click();
				driver.findElement(By.id("downPaymentPercent")).clear();
				driver.findElement(By.id("downPaymentPercent")).sendKeys(""+Percent);
				Mvalue=homePrice-(homePrice*(Percent/100));
				System.out.println("valor de m con porcentaje "+Mvalue);//valor de M
			}
			else{
				driver.findElement(By.id("buttonAmount")).click();
				driver.findElement(By.id("downPayment")).clear();
				driver.findElement(By.id("downPayment")).sendKeys(""+Amount);
				Mvalue=homePrice-Amount;
				System.out.println("valor de m monto "+Mvalue);//valor de M
			}
			
			
			
			driver.findElement(By.xpath("//option[contains(text(),'"+loanterm+"')]")).click();
			driver.findElement(By.id("rate")).clear();
			driver.findElement(By.id("rate")).sendKeys(""+interesrate);
			driver.findElement(By.id("zip")).clear();
			driver.findElement(By.id("zip")).sendKeys("75201");
			driver.findElement(By.xpath("//*[@id='includeTaxesNLabel']")).sendKeys(Keys.ENTER);
			
			setrate=(interesrate/100)/12;
			 String pattern = "#.#######";
			 DecimalFormat decimalFormat =  new DecimalFormat(pattern);//ver si se puede modificar el redondeo
			 String formattedDouble = decimalFormat.format(setrate);
			 double str1 = Double.parseDouble(formattedDouble);
			System.out.println(" tasa "+ str1);//aqui esta la tasa
			
		
		        int months=0;
		         
		        switch (loanterm) 
		        {
		            case "5 Years":  months = 60;
		                     break;
		            case "10 Years":  months = 120;
		            		 break;
		            case "15 Years":  months = 180;
                             break;
                    case "20 Years":  months = 240;
           		             break;
                    case "25 Years":  months = 300;
                             break;
                    case "30 Years":  months = 360;
  		                     break;
		        }
		
		        System.out.println(" meses "+ months);//aqui esta los meses
		        
		       
		        double part1=0;
		        //double part2=0;
		       // Math.pow(numero, 2);
		        
		        //part0= (1+str1);
		        //System.out.println(" cuenta "+ part0);
		       part1=Mvalue*((str1*(Math.pow((1+str1),months)))/((Math.pow((1+str1),months))-1));
		       
		       
		        System.out.println(" cuenta "+ part1);//pendiente aproximar
		      
		        //double d = 9.4568982982989;
		        BigDecimal bd = new BigDecimal(String.valueOf(part1));
		        BigDecimal rounded = bd.setScale(2,RoundingMode.CEILING);
		        System.out.println("BigDecimal rounded off : "+rounded);//modificar nombres de variables
		        
			driver.findElement(By.id("calculateButton")).sendKeys(Keys.ENTER);
			
			//String valor =driver.findElement(By.xpath("//span[contains(text(),'954.83')]")).getText();
			 //System.out.println("sdsdsdsd   "+valor);
			 
			
			 
			 WebElement valori = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'954.83')]")));
				
				System.out.println("sdsdsdsd   "+ valori.getText());
			 
			//span[contains(text(),'954.83')]
			
			//WebElement Info = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='scrollToResult']/div/div[1]/div[1]/div/div[1]/div[2]/p[2]")));
			
		//	System.out.println(" total "+Info.getText());
			 
		
		}

	

}
