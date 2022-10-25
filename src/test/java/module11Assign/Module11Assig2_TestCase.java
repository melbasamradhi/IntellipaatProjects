package module11Assign;
/*Assignment-2
 
 Write a Test Script to Automate https://www.saucedemo.com/index.html Login   & Logout   using Page Object Model 
  -Create Maven Project
  -Use TestNG
  -Create Repository in Class File */
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Module11Assig2_TestCase {
	public WebDriver driver;
	Module11Assig2_Page1 login;
	Module11Assig2_Page2 logout;

	@Test(priority=1)
	public void login_Module() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get("https://www.saucedemo.com/");
		login = new Module11Assig2_Page1(driver);
		login.enter_userName("standard_user");
		login.enter_password("secret_sauce");
		login.click_login();
		String expected_URL = "https://www.saucedemo.com/inventory.html";
		String actual_URL = driver.getCurrentUrl();
		if (actual_URL.equals(expected_URL)) {
			System.out.println("login success-Test case passed");
		} else {
			System.out.println("login not success-Test case failed");
		}
		Assert.assertEquals(expected_URL, actual_URL);
		
}
	@Test(priority=2,dependsOnMethods="login_Module")
	public void logout_Module() throws InterruptedException
	{
		logout=new Module11Assig2_Page2(driver);
		logout.click_Menu();
		logout.click_logout();
		Thread.sleep(6000);
		String exp_URL="https://www.saucedemo.com/";
		String act_URL=driver.getCurrentUrl();
		if(exp_URL.equals(act_URL))
		{
			System.out.println("logout success-Test case passed");
		} else {
			System.out.println("logout not success-Test case failed");
		}
		
	}
	@Test(priority=3,alwaysRun=true)
	public void tear_Down()
	{
		driver.close();
	}
}
