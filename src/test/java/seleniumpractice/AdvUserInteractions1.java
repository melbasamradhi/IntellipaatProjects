package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvUserInteractions1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	WebElement search=	driver.findElement(By.xpath("//input[@name='q']"));
	search.sendKeys("laptop");
		Actions a= new Actions(driver);
		for(int i=1;i<=4;i++)
		{
		a.sendKeys(search,Keys.ARROW_DOWN).build().perform();
		Thread.sleep(4000);
		}
		a.sendKeys(search,Keys.ENTER).build().perform();
		Thread.sleep(7000);
System.out.println(driver.findElement(By.xpath("//span[text()='Sort By']/preceding::*[1]")).getText());

	}

}
