package parameter_xmlfile;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Parameter_Itestcontent {
	public WebDriver driver;
	@Test
	public void facebook_login(ITestContext content) throws IOException, InterruptedException {
		String Browser=	content.getCurrentXmlTest().getParameter("browser")	;
		String url_link=content.getCurrentXmlTest().getParameter("link");
		System.out.println(Browser);
		System.out.println(url_link);
	if(Browser.contains("chrome")) {
		// launch chrome browser
		System.out.println(Browser);
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url_link);
		
		
	} else if (Browser.equalsIgnoreCase("firefox")) {
		// launch firefox browser
		System.out.println(Browser);
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url_link);
	} else if (Browser.equalsIgnoreCase("edge")) {
//launch Edge browser
		System.out.println(Browser);
		System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url_link);
	}
	else
	{
		System.out.println("check the browser name given in the property file");
		
	}
//click create account
	/*String button=prop.getProperty("create_AccountButton");
	driver.findElement(By.xpath(button)).click();
	
	String fName_box=prop.getProperty("firstName_textbox");
	String fName=prop.getProperty("firstName");
	driver.findElement(By.xpath(fName_box)).sendKeys(fName);;
	
	String lName_box=prop.getProperty("lastName_textbox");
	String lName=prop.getProperty("firstName");
	driver.findElement(By.xpath(lName_box)).sendKeys(lName);
	Thread.sleep(7000);*/
	driver.close();
	
}
}
