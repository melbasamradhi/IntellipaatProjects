package parameter_xmlfile;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter_Demo1 {
	public WebDriver driver;
  @Test
  @Parameters({"browser","userName","password"})
  public void verify_SDLogin(String brow,String uname,String pwd) throws InterruptedException {
	  if(brow.contains("chrome"))
	  {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		 driver = new ChromeDriver();
	  }
	  else if(brow.contains("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
	  }
	  else if(brow.contains("edge"))
	  {
		  System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
			driver = new EdgeDriver();
	  }
	  else
	  {
		  System.out.println("check the browser name given in the parameter value");
	  }
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("user-name")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("login-button")).click();
		String expected_URL="https://www.saucedemo.com/inventory.html";
		Thread.sleep(5000);
		String actual_URL=driver.getCurrentUrl();
		Assert.assertEquals(actual_URL, expected_URL);
		driver.close();
	  
  }
}
