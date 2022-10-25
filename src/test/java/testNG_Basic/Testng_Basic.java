package testNG_Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng_Basic {
  @Test
  public void login_module() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		String expected_URL="https://www.saucedemo.com/inventory.html";
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//to fail the testcase by passing wrong password
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("password")).sendKeys("secrte");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		String actual_URL=driver.getCurrentUrl();
		Assert.assertEquals(expected_URL,actual_URL);
		if(actual_URL.contains(expected_URL))
		{
			System.out.println("login success-Test case passed");
		}
		else
		{
			System.out.println("login not success-Test case failed");
		}
		driver.close();
  }
}
