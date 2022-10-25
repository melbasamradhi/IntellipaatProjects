package pageOM_Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class POM_SauceDemo {
	WebDriver driver;
	
	//webelements
	By user_Name=By.id("user-name");
	By password=By.id("password");
	By login=By.id("login-button");
	By addTocart=By.xpath("//button[text()='Add to cart']");
	By cart_Link=By.xpath("//a[@class='shopping_cart_link']");
	By desc_Text=By.xpath("//div[@class='inventory_item_desc']");
	
	//constructor
	public  POM_SauceDemo(WebDriver driver)
	{
		this.driver=driver;
	}
  @Test
  public void enter_userName(String uName) throws InterruptedException {
	  driver.findElement(user_Name).sendKeys(uName);
	  Thread.sleep(4000);
  }
  @Test
  public void enter_password(String pwd) throws InterruptedException {
	  driver.findElement(password).sendKeys(pwd);
	  Thread.sleep(4000);
  }
  
  @Test
  public void click_login() throws InterruptedException {
	  driver.findElement(login).click();;
	  Thread.sleep(4000);
  }
  
  @Test
  public void click_addTocart() throws InterruptedException {
	  driver.findElement(addTocart).click();;
	  Thread.sleep(4000);
  }
  
  @Test
  public void click_cartLink() throws InterruptedException {
	  driver.findElement(cart_Link).click();;
	  Thread.sleep(4000);
  }
  
  @Test
  public String get_descrText() throws InterruptedException {
	 String text= driver.findElement(desc_Text).getText();
	 
	  Thread.sleep(4000);
	return text;
  }
  
  
  
}
