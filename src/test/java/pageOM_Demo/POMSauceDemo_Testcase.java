package pageOM_Demo;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class POMSauceDemo_Testcase {
	 POM_SauceDemo login_page;
	 WebDriver driver;
	
	@BeforeMethod
	public void set_Up() throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
			 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();	
			Thread.sleep(5000);
	  }
	
  @Test(priority=1,dataProvider="loginData")
  public void verify_login(String name,String passwrd) throws InterruptedException {
	  POM_SauceDemo login_page=new POM_SauceDemo(driver);
	  login_page.enter_userName(name);
	  login_page.enter_password(passwrd);
	  login_page.click_login();
	  String expected_URL="https://www.saucedemo.com/inventory.html";
	  String actual_URL=driver.getCurrentUrl();
		if(actual_URL.equals(expected_URL))
		{
			System.out.println("login success-Test case passed");
		}
		else
		{
			System.out.println("login not success-Test case failed");
		}
		Assert.assertEquals(expected_URL,actual_URL);
		Thread.sleep(5000);
  }
  @AfterMethod
  public void test_Result(ITestResult result) throws InterruptedException
  {
	int status=  result.getStatus();
	//if login is success, click "add to cart", go to "your cart" and get the text displayed
	if(status==1)
	{
		login_page=new POM_SauceDemo(driver);
		login_page.click_addTocart();
		login_page.click_cartLink();
		System.out.println(login_page.get_descrText());
		
	  driver.close();
	}
	else
	{
		//take screenshot and close if login fails
		File target=new File("C:\\Selenium_training\\test\\src\\test\\resources\\"+result.getParameters()[0]+"default.jpeg");
		TakesScreenshot ts= (TakesScreenshot) driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src,target);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.close();
	}
  }
  
  @DataProvider(name="loginData")
  public Object sD_login() throws BiffException, IOException
  {
	  File f= new File("C:\\Selenium_training\\test\\src\\test\\resources\\logindata.xls");
	Workbook w=  Workbook.getWorkbook(f);
	Sheet s=w.getSheet(0);
	int no_col=s.getColumns();
	int no_row=s.getRows();
	Object [][]data=new Object[no_row-1][no_col];
	
	for(int i=1;i<=no_row-1;i++)
	{
		int r=i-1;
		for(int j=0;j<=no_col-1;j++)
		{
			data[r][j]=s.getCell(j, i).getContents();
		}
	}
	return data;
	  
  }
}
