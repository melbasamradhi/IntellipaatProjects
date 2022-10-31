package module4Assign;
/* Write a Test Script to get no of links available on Facebook Page 
     https://www.facebook.com/	*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module4_Assig4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		List<WebElement> links=	driver.findElements(By.tagName("a"));
		System.out.println("no of links="+links.size());
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
		}

		Thread.sleep(7000);
		driver.close();
		

	}

}
