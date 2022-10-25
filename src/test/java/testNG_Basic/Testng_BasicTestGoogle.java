package testNG_Basic;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng_BasicTestGoogle {
  @Test
  public void google_page() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		
	Boolean search_Button=	driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@class='gNO89b']")).isDisplayed();
	System.out.println(search_Button);
	Assert.assertEquals(true,search_Button);
	Boolean gmail_link=	driver.findElement(By.xpath("//a[text()='Gmail']")).isDisplayed();
	System.out.println(gmail_link);
	Assert.assertEquals(true,gmail_link);
	driver.close();
  }
}
