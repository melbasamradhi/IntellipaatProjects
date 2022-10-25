package module7assign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Test Scenario I:---File Download  
Step-1 Launch Firefox Browser
Step-2 Open Test URL https://www.selenium.dev/downloads/
Step-3 In table Selenium Client & WebDriver Language Bindings, automate the plain text   
Step-4 Get the plain text Java , Python  into Console   
Step-5 Close Browser*/
public class Module7_Assig4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe")	;
		WebDriver driver = new FirefoxDriver() ;
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
	String text1=	driver.findElement(By.xpath("//h2[contains(text(),'Selenium Clients')]")).getText();
	String text2=	driver.findElement(By.xpath("//h2[contains(text(),'Selenium Clients')]/following::*[1]")).getText();
	String text3=	driver.findElement(By.xpath("//h2[contains(text(),'Selenium Clients')]/following::*[2]")).getText();
	String text4=	driver.findElement(By.xpath("//p[text()='Ruby']")).getText();
	String text5=	driver.findElement(By.xpath("//p[text()='Java']")).getText();
	System.out.println(text1);
	System.out.println(text2);
	System.out.println(text3);
	System.out.println(text4);
	System.out.println(text5);
	driver.close();
	}

}
