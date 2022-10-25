package module9Assign;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
/*Write a TestScript to Automate https://www.saucedemo.com/index.html Login  in TestNG
	-Pass parameters from .xml file */
import org.testng.annotations.Test;

public class Module9_Assig3_Itestcontent {
	public WebDriver driver;
  @Test
  public void verify_sdLogin(ITestContext content) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String expected_URL = "https://www.saucedemo.com/inventory.html";
		String uName=content.getCurrentXmlTest().getParameter("username");
		System.out.println(uName);
		String passwrd=content.getCurrentXmlTest().getParameter("password");
		System.out.println(passwrd);
		driver.findElement(By.id("user-name")).sendKeys(uName);
		driver.findElement(By.id("password")).sendKeys(passwrd);
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		String actual_URL = driver.getCurrentUrl();
		if (actual_URL.equals(expected_URL)) {
			System.out.println("login success-Test case passed");
		} else {
			System.out.println("login not success-Test case failed");
		}
		Assert.assertEquals(expected_URL, actual_URL);
		Thread.sleep(5000);
		driver.close();
  }
}
