package module4Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

/*1. Write a TestScript for  following

  TC-1 Launch Chrome Browser 
  TC-2 Goto Facebook Registration Page 
  TC-3 Fill FirstName TextBox with Input
  TC-4 Clear the input from  FirstName TextBox
  TC-5 Again Fill the  FirstName TextBox with Input
  TC-6 Get the Input from TextBox  and display it in Console 
  TC-6 Close Browser 
  */
public class Module4_Assig5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		WebElement firstname= driver.findElement(By.name("firstname"));
		firstname.sendKeys("xxxx");
		Thread.sleep(4000);
		firstname.clear();
		Thread.sleep(4000);
		firstname.sendKeys("yyyy");
		Thread.sleep(4000);
		String name=firstname.getAttribute("value");
		System.out.println(name);
		driver.close();
		
		

	}

}
