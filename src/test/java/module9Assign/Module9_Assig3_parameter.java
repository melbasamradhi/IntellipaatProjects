package module9Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Module9_Assig3_parameter {
	@Parameters({"username","password"})
	@Test()
	 public void verify_sdLogin(String uName,String passwrd) throws InterruptedException
	 {
	 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		String expected_URL = "https://www.saucedemo.com/inventory.html";
		
		System.out.println(uName);
		
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
