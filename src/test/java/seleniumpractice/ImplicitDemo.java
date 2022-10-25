package seleniumpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
		driver.findElement(By.xpath("//input[@name='btnK']")).click();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		System.out.println(links.get(0).getText());
		List<WebElement> linkStartwith_a = driver.findElements(By.xpath("//a[contains(text(),'a')]"));
		System.out.println(linkStartwith_a.size());
		driver.close();
	}

}
