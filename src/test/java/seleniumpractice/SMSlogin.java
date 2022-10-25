package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SMSlogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fast2sms.com/referral/bF8mZJYo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.findElement(By.name("signup_dob")).click();
		//ul[@class='pick pick-m']//i[@class='pick-i-r']
		WebElement month=driver.findElement(By.xpath("//ul[@class='pick pick-m']//i[@class='pick-i-r']"));
		Actions a= new Actions(driver);
		a.moveToElement(month).build().perform();
	Thread.sleep(5000);
	for(int i=0;i<=5;i++)
	{
	a.click(month).build().perform();
	}
		//JavascriptExecutor js=(JavascriptExecutor) driver;
	//	js.executeScript("arguments[0].click()",month);
		

	}

}
