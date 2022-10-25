package module8Assign;
/*Assignment-4
 
 Write a Test Script to Automate Way2sms Login using Page Object Model */
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Module8_Assig4POM_TC {
	WebDriver driver;
	Module8_Assig4POM login;

	@Test
	public void login_data() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.fast2sms.com/referral/bF8mZJYo");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		login =new Module8_Assig4POM(driver);
		login.enter_fName("xxxx");
		login.click_dob();
		login.select_month();	
		login.select_date();
		login.select_year();	
		login.click_submitdob();
		login.enter_mobNo("xx1234567");	
		login.enter_email("xx@gmail.com");	
		login.click_termsCond();
		login.click_submitButton();
		Thread.sleep(6000);
		
	}
	@AfterMethod
	public void tear_Down(ITestResult result)
	{
		//takescreenshot and close the browser
		TakesScreenshot ts= (TakesScreenshot) driver;
	File src=	ts.getScreenshotAs(OutputType.FILE);
	File target=new File("C:\\Selenium_training\\test\\src\\test\\resources\\"+result.getTestName()+"smslogin.jpeg");
	try {
		FileUtils.copyFile(src, target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.close();
	}
}
