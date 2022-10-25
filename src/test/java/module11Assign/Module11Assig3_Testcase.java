package module11Assign;
/*Assignment-3
 Write a Test Script to Automate https://www.saucedemo.com/index.html Login   using Page Object Model 
  -Create Maven Project
  -Use TestNG 
  -USe properties files to store Data and Objects*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Module11Assig3_Testcase {
	public WebDriver driver;
	Module11Assig3_Page1 login;

	@Test
	public void login_Module() throws InterruptedException, IOException {
		Properties prop = new Properties();
		FileInputStream fip = new FileInputStream(
				"C:\\Selenium_training\\test\\src\\test\\java\\module11Assign\\module11_Assig3.properties");
		prop.load(fip);
		String uName = prop.getProperty("username");
		String passwrd = prop.getProperty("password");
		String usName_addr = prop.getProperty("username_address");
		String passwrd_add = prop.getProperty("password_address");
		String login_add = prop.getProperty("loginbutton_address");
		String link = prop.getProperty("url");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get(link);
		login = new Module11Assig3_Page1(driver);
		login.enter_userName(usName_addr, uName);
		login.enter_password(passwrd_add, passwrd);
		login.click_login(login_add);

		String expected_URL = prop.getProperty("exp_url");
		String actual_URL = driver.getCurrentUrl();
		if (actual_URL.equals(expected_URL)) {
			System.out.println("login success-Test case passed");
		} else {
			System.out.println("login not success-Test case failed");
		}
		Assert.assertEquals(expected_URL, actual_URL);
		driver.close();

	}

}
