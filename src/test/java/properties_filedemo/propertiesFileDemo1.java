package properties_filedemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class propertiesFileDemo1 {
	public WebDriver driver;
	public Properties prop;

	
	
	@Test
	public void facebook_Login() throws IOException, InterruptedException {
		// for reading the input from properties file
		FileInputStream fip=new FileInputStream("C:\\Selenium_training\\test\\src\\test\\java\\properties_filedemo\\testData.properties");
		 prop=new Properties();
		 prop.load(fip);
		String Browser=prop.getProperty("browser");
		String url_link=prop.getProperty("link");
		
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
		String button=prop.getProperty("create_AccountButton");
		driver.findElement(By.xpath(button)).click();
		
		String fName_box=prop.getProperty("firstName_textbox");
		String fName=prop.getProperty("firstName");
		driver.findElement(By.xpath(fName_box)).sendKeys(fName);;
		
		String lName_box=prop.getProperty("lastName_textbox");
		String lName=prop.getProperty("lastName");
		driver.findElement(By.xpath(lName_box)).sendKeys(lName);
		Thread.sleep(7000);
		driver.close();
		
	}
	}

