package module3Assign;
/*TC-1	Launch Chrome  Browser
TC-2	Go to Test URL  https://www.google.com
TC-3	Maximize the Browser Window
TC-4	Get the URL of Page
TC-5	Navigate to Test URL  https://www.selenium.dev/
TC-6	Get the URL of Page
TC-7	Navigate back to Test URL  https://www.google.com
TC-8    Get the URL of Page 
TC-8	Navigate one step forward to Test URL  https://www.selenium.dev/ 
TC-9    Get the URL of Page 
TC-10	Refresh the Current Page 
TC-11	Get the URL of Page 
TC-12   Close the Browser */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Module3_Assig5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		String pageUrl_1=driver.getCurrentUrl();
		System.out.println(pageUrl_1);
		driver.navigate().to("https://www.selenium.dev/");
		Thread.sleep(5000);
		String pageUrl_2=driver.getCurrentUrl();
		System.out.println(pageUrl_2);
		driver.navigate().back();
		Thread.sleep(5000);
		String pageUrl_3=driver.getCurrentUrl();
		System.out.println(pageUrl_3);
		driver.navigate().forward();
		Thread.sleep(5000);
		String pageUrl_4=driver.getCurrentUrl();
		System.out.println(pageUrl_4);
		driver.navigate().refresh();
		Thread.sleep(5000);
		String pageUrl_5=driver.getCurrentUrl();
		System.out.println(pageUrl_5);
		driver.close();
		

	}

}
