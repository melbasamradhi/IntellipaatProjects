package module9Assign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Module9_Assig4_propertiesfile {
  @Test
  public void verify_SDlogin() throws IOException, InterruptedException {
	  Properties prop=new Properties();
	  FileInputStream fip=new FileInputStream("C:\\Selenium_training\\test\\src\\test\\java\\module9Assign\\module9_Assig4.properties");
	  prop.load(fip);
		String uName=prop.getProperty("username");
		String passwrd=prop.getProperty("password");
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

