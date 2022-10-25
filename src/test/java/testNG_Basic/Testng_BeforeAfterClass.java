package testNG_Basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
/*TS1...Launch chrome browser;
 *TS2...Go to https://www.saucedemo.com/;verify the page title;
 *TS3...Go to https://www.selenium.dev/ ;verify the page title;
 *TS4...Go to https://www.google.com/;verify the page title;
 *TS5...Close the browser
 * 
 */
import org.testng.annotations.Test;

public class Testng_BeforeAfterClass {
	public WebDriver driver;

	// Launch ChromeBrowser
	@BeforeClass
	public void set_Up() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(4000);
	}

	// Close the browser
	@AfterClass
	public void tear_Down() {
		driver.close();
	}

	// to verify the title in sausedemo webpage
	@Test(priority = 1)
	public void verify_SDpage() throws InterruptedException {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String expec_Title = "Swag Labs";
		String actual_Title = driver.getTitle();
		Assert.assertEquals(actual_Title, expec_Title);
	}

	// to verify the title in selenium webpage
	@Test(priority = 2)
	public void verify_Seleniumpage() throws InterruptedException {
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String expec_Title = "Selenium";
		String actual_Title = driver.getTitle();
		Assert.assertEquals(actual_Title, expec_Title);
	}

	// to verify the title in Google webpage
	@Test(priority = 3)
	public void verify_Googlepage() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String expec_Title = "Google";
		String actual_Title = driver.getTitle();
		Assert.assertEquals(actual_Title, expec_Title);
	}

}
