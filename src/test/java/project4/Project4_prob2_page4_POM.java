package project4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project4_prob2_page4_POM {
	public WebDriver driver;
	//constructor
	public  Project4_prob2_page4_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Webelements on page 1 of suacedemo labs
	By first_name=By.id("first-name");
	By last_Name=By.id("last-name");
	By postal_code=By.id("postal-code");
	By continue_button=By.id("continue");
	
	//operation on the webelements
	
	public void enter_firstname(String fname) {
		driver.findElement(first_name).sendKeys(fname);
	}
	
	public void enter_lastname(String lname) {
		driver.findElement(last_Name).sendKeys(lname);
	}
	
	public void enter_postalcode(String pincode) {
		driver.findElement(postal_code).sendKeys(pincode);
	}
	
	public void click_continuebutton() {
		driver.findElement(continue_button).click();
	}
	
	
	
}
