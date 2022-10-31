package seleniumscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6_browserNavi {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		
		//driver.get("https://www.google.com/");
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		driver.navigate().back();
		Thread.sleep(5000);
		
		driver.navigate().forward();
		Thread.sleep(5000);
		
		driver.close();
		

	}

}
