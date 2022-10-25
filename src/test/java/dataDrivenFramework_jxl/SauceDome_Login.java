package dataDrivenFramework_jxl;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
/*to verify the login page in https://www.saucedemo.com/ with 5 user and password combinations
 Valid input..........	standard_user................secret_sauce
Valid input...........	locked_out_user............. secret_sauce
Valid input...........	problem_user..............   secret_sauce
Valid input	............performance_glitch_user..... secret_sauce
Invalid input	        test.........................secret
 */
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class SauceDome_Login {
	public WebDriver driver;
	@Test(dataProvider="loginData")
	  public void login_module(String uName,String passwrd) throws InterruptedException {
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
			 driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			String expected_URL="https://www.saucedemo.com/inventory.html";
			driver.findElement(By.id("user-name")).sendKeys(uName);
			//to fail the testcase by passing wrong password
			//driver.findElement(By.id("password")).sendKeys("secret_sauce");
			driver.findElement(By.id("password")).sendKeys(passwrd);
			driver.findElement(By.id("login-button")).click();
			Thread.sleep(5000);
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
	public void testResult(ITestResult result) 
	{
	int status=	result.getStatus();
	if(status==1)
	{
		System.out.println("Test Name :"+ result.getTestName()+" is passed");
		driver.close();
	}
	else
	{
		//take screenshot
		File target=new File("C:\\Selenium_training\\test\\src\\test\\resources\\"+result.getParameters()[0]+"default.jpeg");
	//	TakesScreenshot ts=(TakesScreenshot)driver;
	//	File srsc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//	 File srsc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
		WebElement error=driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface')]"));
	File srsc=	error.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srsc,target);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		driver.close();
	}
	}
	
	@DataProvider(name="loginData")
	
	public Object[][] read_Excel() throws BiffException, IOException
	{
		File f= new File("C:\\Selenium_training\\test\\src\\test\\resources\\logindata.xls");
		Workbook w= Workbook.getWorkbook(f);
		Sheet s=w.getSheet(0);
	int no_OfRow=	s.getRows();
	int no_OfCol=s.getColumns();
		Object[][] inputData =new Object[no_OfRow-1][no_OfCol];
		for(int i=1;i<=no_OfRow-1;i++)
		{
			int r=i-1;
			for(int j=0;j<=no_OfCol-1;j++)
			{
				Cell c=s.getCell(j, i);
				inputData[r][j]=c.getContents();
			}
		}
		return inputData;
		
	}
}
