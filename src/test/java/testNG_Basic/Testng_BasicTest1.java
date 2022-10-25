package testNG_Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng_BasicTest1 {
  @Test
  public void loginmodule() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//to fail the testcase by passing wrong password
		driver.findElement(By.id("password")).sendKeys("secrte");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
	Boolean error=driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]")).isDisplayed();
	if(error==true)
	{
		System.out.println("login not success-Test case failed");
	}
	else
	{
		System.out.println("login  success-Test case passed");
	}
		Assert.assertEquals(false, error);
		
		driver.close();
  }
}
