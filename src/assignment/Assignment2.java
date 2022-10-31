package assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/*https://www.facebook.com/
-Click on  CreateNew Account Button
-Click on DataPolicy Linktext*/
public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		Thread.sleep(4000);
		WebElement forget_Pw = driver.findElement(By.linkText("Forgotten password?"));
		By createAcc = RelativeLocator.with(By.tagName("a")).below(forget_Pw);
		driver.findElement(createAcc).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Cookies Policy")).click();
		Thread.sleep(4000);
		driver.quit();
	}

}
