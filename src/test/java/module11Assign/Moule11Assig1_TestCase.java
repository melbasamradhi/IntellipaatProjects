package module11Assign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
/*Assignment-1
 
 Write a Test Script to Automate https://www.saucedemo.com/index.html Login   using Page Object Model 
  -Create Maven Project
  -Use TestNG
  -Create Repository in Class File */
import org.testng.annotations.Test;

public class Moule11Assig1_TestCase {
	public WebDriver driver;
	Module11Assig1_POM login;

	@Test
	public void login_Module() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://www.saucedemo.com/");
		login = new Module11Assig1_POM(driver);
		login.enter_userName("standard_user");
		login.enter_password("secret_sauce");
		login.click_login();
		String expected_URL = "https://www.saucedemo.com/inventory.html";
		String actual_URL = driver.getCurrentUrl();
		if (actual_URL.equals(expected_URL)) {
			System.out.println("login success-Test case passed");
		} else {
			System.out.println("login not success-Test case failed");
		}
		Assert.assertEquals(expected_URL, actual_URL);
		driver.close();

	}
		
}
