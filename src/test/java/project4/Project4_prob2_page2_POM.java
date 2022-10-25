package project4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Project4_prob2_page2_POM {
	public WebDriver driver;
	//constructor
	public  Project4_prob2_page2_POM(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//WebElements
	By addtocart_1= By.xpath("(//button[text()='Add to cart'])[1]");
	By addtocart_2= By.xpath("(//button[text()='Add to cart'])[2]");
	By addtocart_3= By.xpath("(//button[text()='Add to cart'])[3]");
	By addtocart_4= By.xpath("(//button[text()='Add to cart'])[4]");
	By addtocart_5= By.xpath("(//button[text()='Add to cart'])[5]");
	By addtocart_6= By.xpath("(//button[text()='Add to cart'])[6]");
	By menu= By.xpath("//button[text()='Open Menu']");
	By checkout=By.xpath("//div[@id='shopping_cart_container']/a");
	By logout=By.xpath("//a[@id='logout_sidebar_link']");
	
	//opeartions on the webelements
	
	public void click_addtocart()
	{
	driver.findElement(addtocart_1).click();
	driver.findElement(addtocart_4).click();
	}
	
	public void click_menu()
	{
		driver.findElement(menu).click();	
	}
	
	public void click_cart()
	{
		driver.findElement(checkout).click();	
	}
	
	public void click_logout()
	{
		driver.findElement(logout).click();	
	}
	}
	
	

