package module3Assign;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Assignment-2

TC-1	Launch Chrome Browser
TC-2	Go to Test URL https://demoqa.com/browser-windows
TC-3	Maximize the Browser Window
TC-4	Get the Title of Page
TC-5	Click on knowmore Link Text 
TC-6	Switch from 0th   Window to 1st   Window
TC-7	After Switching Get the Title of Page 
TC-8    Close 1st Window 
TC-8	Switch from 1st   Window to 0th  Window
TC-9    After Switching Get the Title of Page 
TC-10	Close 0th Window  */
public class Module3_Assig2Chrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		String pageTitle1=driver.getTitle();
		System.out.println(pageTitle1);
		driver.findElement(By.id("windowButton")).click();
		Thread.sleep(4000);
	 driver.getWindowHandles();
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
	driver.close();

	}

}
