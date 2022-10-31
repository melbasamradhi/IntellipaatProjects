package seleniumscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// to find the number of links in facebook 
public class NoOFLinks {

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
driver.findElement(By.partialLinkText("Learn")).click();
Thread.sleep(4000);

ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
driver.switchTo().window(windows.get(1));
Thread.sleep(5000);
List<WebElement> para=driver.findElements(By.tagName("span"));
System.out.println("no of para="+para.size());
Thread.sleep(5000);
driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]")).click();
Thread.sleep(5000);
driver.quit();
	}
	
	

}
