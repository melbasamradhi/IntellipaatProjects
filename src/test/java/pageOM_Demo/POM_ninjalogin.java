package pageOM_Demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class POM_ninjalogin {
	WebDriver driver;
	//constructor
	public POM_ninjalogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//webelements
	By f_Name=By.id("input-firstname");
	By l_Name=By.id("input-lastname");
	By eMail=By.id("input-email"); 
	By phoneNo=By.id("input-telephone");
	By passwrd=By.id("input-password");
	By passwrd_confirm=By.id("input-confirm");
	By subscribe_no=By.xpath("//label[text()='Subscribe']/following::*[4]");
	By subscribe_yes=By.xpath("//label[text()='Subscribe']/following::*[3]");
	
  
  public void enter_firstName(String fName) {
	  driver.findElement(f_Name).sendKeys(fName);
	  
  }
  public void enter_lastName(String lName) {
	  driver.findElement(l_Name).sendKeys(lName);
	  
  }
  
  public void enter_mailid(String emailid) {
	  driver.findElement(eMail).sendKeys(emailid); 
  }
 
  public void enter_phoneNo(String phNo) {
	  driver.findElement(phoneNo).sendKeys(phNo); 
  }
  
  public void enter_pwrd(String pwd) {
	  driver.findElement(passwrd).sendKeys(pwd); 
  }
  

  public void reenter_pwrd(String pwd) {
	  driver.findElement(passwrd_confirm).sendKeys(pwd); 
  }
  
 
  public void subscription(String option) {
	  if(option.equalsIgnoreCase("no"))
	  {
	  driver.findElement(subscribe_no).click(); 
	  }
	  else
	  {
		  driver.findElement(subscribe_yes).click();  
	  }
  }
  
  
}
