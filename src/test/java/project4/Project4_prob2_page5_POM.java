package project4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project4_prob2_page5_POM {
	public WebDriver driver;
	//constructor
	public  Project4_prob2_page5_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Webelements on page 1 of suacedemo labs
	
	By finish_button=By.id("finish");
	
	//operation on webelements
	
	public void click_finishbutton()
	{
		driver.findElement(finish_button).click();
	}

}
