package Silkuli;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliDemoFlipKart {

	public static void main(String[] args) throws FindFailed, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		Thread.sleep(5000);
		Screen s= new Screen();
		s.hover("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\FlipK_fashion.PNG");
		Thread.sleep(5000);
		//Pattern input= new Pattern("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocato\\FlipKart_search.PNG");
		s.type("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\FlipKart_search.PNG","laptop");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		driver.close();
	}

}
