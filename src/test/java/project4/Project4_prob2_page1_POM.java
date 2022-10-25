package project4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project4_prob2_page1_POM {
	public WebDriver driver;
	//constructor
	public  Project4_prob2_page1_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Webelements on page 1 of suacedemo labs
	
	By user_Name=By.id("user-name");
	By pass_word=By.id("password");
	By login=By.id("login-button");
	
	//operation on the webelements
	
	public void enter_Username(String name)
	{
		driver.findElement(user_Name).sendKeys(name);
	}
	
	public void enter_password(String pwd)
	{
		driver.findElement(pass_word).sendKeys(pwd);
	}
	
	public void click_login()
	{
		driver.findElement(login).click();
	}
	
	
	

}
