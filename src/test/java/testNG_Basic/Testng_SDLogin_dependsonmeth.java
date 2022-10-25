package testNG_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng_SDLogin_dependsonmeth {
public WebDriver driver;
	
	@Test(priority=1)
	public void set_Up() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 driver = new ChromeDriver();
		
	}
	@Test(dependsOnMethods= {"set_Up"})
	public void open_URL() throws InterruptedException{
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods= {"open_URL"})
	public void user_Name() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	@Test(dependsOnMethods= {"user_Name"})
	public void password() {
		driver.findElement(By.id("password")).sendKeys("secret");
	}
	@Test(dependsOnMethods= {"password"})
	public void click_login() throws InterruptedException {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
	}
	@Test(dependsOnMethods= {"click_login"})
	public void validate_login() {
		String expected_URL="https://www.saucedemo.com/inventory.html";
		String actual_URL=driver.getCurrentUrl();
		Assert.assertEquals(actual_URL, expected_URL);
	}
	@Test(dependsOnMethods= {"validate_login"},alwaysRun=true)
	public void tear_Down() {
		driver.close();
	}
}
