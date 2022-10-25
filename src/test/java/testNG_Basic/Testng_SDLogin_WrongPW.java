package testNG_Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng_SDLogin_WrongPW {
  
  public WebDriver driver;
	
	@Test(priority=1)
	public void set_Up() {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 driver = new ChromeDriver();
		
	}
	@Test(priority=2)
	public void open_URL() throws InterruptedException{
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void user_Name() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	@Test(priority=4)
	public void password() {
		driver.findElement(By.id("password")).sendKeys("secret");
	}
	@Test(priority=5)
	public void click_login() throws InterruptedException {
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
	}
	@Test(priority=6)
	public void validate_login() {
		String expected_URL="https://www.saucedemo.com/inventory.html";
		String actual_URL=driver.getCurrentUrl();
		Assert.assertEquals(actual_URL, expected_URL);
	}
	@Test(priority=7,alwaysRun=true)
	public void tear_Down() {
		driver.close();
	}
	
}
