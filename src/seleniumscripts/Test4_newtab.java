package seleniumscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test4_newtab {

	
		public static void main(String[] args) throws InterruptedException {
			//	TC-1 Launch ChromeBrowser
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
			WebDriver driver = new ChromeDriver();
			//TC-2 Go to test URL https://www.google.com
			driver.get("https://www.facebook.com/");
			 // TC-3 Specify wait time for 5 sec
			Thread.sleep(5000);
			//TC-4 Get the title of the page in the console
			String pageTitle=driver.getTitle();
			System.out.println(pageTitle);
			Thread.sleep(5000);
			//TC-5 Minimize browser window
			driver.manage().window().minimize();
			Thread.sleep(5000);
			// TC-6 Maximize browser window
			driver.manage().window().maximize();
		Thread.sleep(5000);
		//TC-7 Get the current URL of the page
		String pageUrl=driver.getCurrentUrl();
		System.out.println(pageUrl);
		Thread.sleep(5000);
		//TC-8 open the new tab
		
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		
		
		//TC-8 Close the browser
		//driver.close();
		driver.quit();
			

	}

}
