package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvUserInteractions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
	WebElement fashion=	driver.findElement(By.xpath("//div[text()='Fashion']"));
	//mouse hover on fashion
	Actions a =new Actions(driver);
	a.moveToElement(fashion).build().perform();
	//mouse hover on women ethnic
	WebElement womEthnic=driver.findElement(By.xpath("//a[text()='Women Ethnic']"));
	a.moveToElement(womEthnic).build().perform();//a[text()='Women Sarees']
	a.click().build().perform();
	//driver.findElement(By.xpath("//a[text()='Women Sarees']")).click();
	System.out.println(driver.findElement(By.xpath("//h2[text()='Brands you Love']")).getText());
	driver.close();
	}

}
