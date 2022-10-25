package module11Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*Assignment-2
 
 Write a Test Script to Automate https://www.saucedemo.com/index.html Login   & Logout   using Page Object Model 
  -Create Maven Project
  -Use TestNG
  -Create Repository in Class File */
public class Module11Assig2_Page1 {
	public WebDriver driver;
	//constructor
	public  Module11Assig2_Page1(WebDriver driver)
	{
		this.driver=driver;
	}
	//Webelements
	By user_Name=By.id("user-name");
	By password=By.id("password");
	By login=By.id("login-button");
	
 
  public void enter_userName(String uName) throws InterruptedException {
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	  driver.findElement(user_Name).sendKeys(uName);
	  Thread.sleep(4000);
  }
  
  public void enter_password(String pwd) throws InterruptedException {
	  driver.findElement(password).sendKeys(pwd);
	  Thread.sleep(4000);
  }
  
  
  public void click_login() throws InterruptedException {
	  driver.findElement(login).click();;
	  Thread.sleep(4000);
  }
  
	


}
