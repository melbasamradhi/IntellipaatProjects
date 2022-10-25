package module11Assign;
/*Assignment-4
 
 Write a Test Script to Automate https://www.saucedemo.com/index.html Login module & Logout    using Page Object Model 
  -Create Maven Project
  -Use TestNG
  -USe properties files to store Data and Objects*/
  
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Module11Assig4_Testcase {
	public WebDriver driver;
	public Properties prop;
	Module11Assig4_page1 login;
	Module11Assig4_page2 logout;
	

	@Test(priority=1)
	public void login_Module() throws InterruptedException, IOException {
		 prop=new Properties();
		  FileInputStream fip=new FileInputStream("C:\\Selenium_training\\test\\src\\test\\java\\module11Assign\\module11_Assig4.properties");
		  prop.load(fip);
			String usName=prop.getProperty("username");
			String usName_addr=	prop.getProperty("username_address");
			String passwrd=prop.getProperty("password");
			String passwrd_add=prop.getProperty("password_address");
			String login_add=prop.getProperty("loginbutton_address");
			String link=prop.getProperty("url");
			String expURL=prop.getProperty("exp_url");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.get(link);
		login = new Module11Assig4_page1(driver);
		login.enter_userName(usName_addr,usName);
		login.enter_password(passwrd_add,passwrd);
		login.click_login(login_add);
		
		String actual_URL = driver.getCurrentUrl();
		if (actual_URL.equals(expURL)) {
			System.out.println("login success-Test case passed");
		} else {
			System.out.println("login not success-Test case failed");
		}
		Assert.assertEquals(expURL, actual_URL);
		
}
	@Test(priority=2,dependsOnMethods="login_Module")
	public void logout_Module() throws InterruptedException
	{
		String clickmenu_addr=prop.getProperty("clickmenu_add");
		String logou_addre =prop.getProperty("logout_add");
		logout=new Module11Assig4_page2(driver);
		logout.click_Menu(clickmenu_addr);
		logout.click_logout(logou_addre);
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
