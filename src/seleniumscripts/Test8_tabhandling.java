package seleniumscripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test8_tabhandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		String pageTitle1=driver.getTitle();
		System.out.println(pageTitle1);
		driver.findElement(By.id("tabButton")).click();
		Thread.sleep(4000);
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(windows.get(1));
		Thread.sleep(4000);
		String pageUrl=driver.getCurrentUrl();
		System.out.println(pageUrl);
		String text=driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(text);
		driver.switchTo().window(windows.get(0));
		Thread.sleep(4000);
		String pageTitle3=driver.getTitle();
		System.out.println(pageTitle3);
		driver.quit();

	}

}
