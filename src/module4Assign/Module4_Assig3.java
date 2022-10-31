package module4Assign;
/* 1.	Automate Facebook Registration Page  using Absolute X-path in Chrome Browser
     https://www.facebook.com/	*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Module4_Assig3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("xxxx");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("yyyy");
		Thread.sleep(3000);	
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("12345");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[4]/div[1]/div[1]/input[1]")).sendKeys("rrr123");
		Thread.sleep(3000);
		Select day =new Select(driver.findElement(By.id("day")));
		day.selectByIndex(4);
		Select month =new Select(driver.findElement(By.id("month")));
		month.selectByValue("6");
		Select year =new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1990");
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(4000);
		driver.close();
		
	}

}

