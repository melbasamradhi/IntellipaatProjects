package test1_Edge;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class EdgeDemo {
	@Test
	public void browserAction() throws InterruptedException {
//		TC-1 Launch EdgeBrowser
		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe")	;
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//TC-2 Go to test URL https://www.google.com
		driver.get("https://www.google.com/");
		 // TC-3 Specify wait time for 5 sec
		Thread.sleep(5000);
		//TC-4 Get the title of the page in the console
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		
		//TC-5 Minimize browser window
		driver.manage().window().minimize();
		Thread.sleep(5000);
		// TC-6 Maximize browser window
		driver.manage().window().maximize();
		Thread.sleep(5000);
	//TC-7 Get the current URL of the page
	String pageUrl=driver.getCurrentUrl();
	System.out.println(pageUrl);
	
	//TC-8 Close the browser
	driver.close();
		
		
  }
}
