package seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*sendkeys();
Syntax:
driver.findElement(By.ElementLocator("value").sendkeys("input data");
     driver.findElement(By.name("xxxx")).sendkeys("xxx");   
     driver.findElement(By.name("xxxx")).sendkeys("xxx",Keys.TAB);
      driver.findElement(By.name("xxxx")).sendkeys("xxx",Keys.chord(Keys.ALT,Keys.F4)); 
          
*/
public class SendKeysDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		WebElement fName=driver.findElement(By.name("firstname"));
		fName.sendKeys("xxxx");
		Thread.sleep(2000);
		driver.findElement(By.name("lastname")).sendKeys("yyyy",Keys.chord(Keys.SHIFT,Keys.TAB));
		Thread.sleep(2000);
		System.out.println(fName.getAttribute("value"));
		fName.clear();
		fName.sendKeys("hello2",Keys.BACK_SPACE);
		Thread.sleep(4000);
		System.out.println(fName.getAttribute("value"));
		driver.close();
		
		
	}

}
