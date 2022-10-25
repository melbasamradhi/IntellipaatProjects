package keyboardDriven_FW;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ActionKeywords {
	public WebDriver driver;
	
  @Test(priority=1)
  public void openbrowser() {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
	 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  
  }
  
  @Test(priority=2)
  public void navigate() {
	  driver.get("https://www.saucedemo.com/");
	  
  }
  
  @Test(priority=3)
  public void inputusername() {
	  driver.findElement(By.id("user-name")).sendKeys("standard_user");
	  
  }
  
  @Test(priority=4)
  public void inputpassword() {
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
  }
  
  @Test(priority=5)
  public void clicklogin() throws InterruptedException {
	  driver.findElement(By.id("login-button")).click();
	  Thread.sleep(5000);
	  TakesScreenshot ts= (TakesScreenshot) driver;
	File src=  ts.getScreenshotAs(OutputType.FILE);
	File target=new File("C:\\Selenium_training\\test\\src\\test\\resources\\"+"KeyboardDriven.jpeg");
	try {
		FileUtils.copyFile(src, target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
  }
  
  @Test(priority=6)
  public void closebrowser() {
	  driver.close();
	  
  }
}
