package project4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project4_prob2_page3_POM {
	public WebDriver driver;
	//constructor
	public  Project4_prob2_page3_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Webelements on page 3 of suacedemo labs
	By checkout_button=By.id("checkout");
	
	//operation on the webelements
	public void click_checkoutbutton()
	{
		driver.findElement(checkout_button).click();
	}

}
