package dataDrivenFramework_jxl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class POMSauceDemo_sample {
	public WebDriver driver;
	@Test(dataProvider="SD_TestData")
	public void login_SDPage(String username, String pwd) throws InterruptedException {

		//Launch Chrome Browser
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	 driver = new ChromeDriver();

		//Goto Test URL https://www.saucedemo.com/
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);

		//UserName
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
		Thread.sleep(5000);	

		//Password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pwd);
		Thread.sleep(5000);	

		//LOGIN Button
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		Thread.sleep(5000);	

		String expecURL="https://www.saucedemo.com/inventory.html";
		String actURL=driver.getCurrentUrl();

		if(actURL.equals(expecURL))
		{
			System.out.println("Login Success - Test Passed");
		}
		else
		{
			System.out.println("Login Failed - Test Failed");
		}

		Assert.assertEquals(expecURL, actURL);
		Thread.sleep(5000);

	}


	@AfterMethod
	public void getTestResult(ITestResult testResult)
	{
		System.out.println("TestCase Name : "+testResult.getName());
		System.out.println("TestCase Result : "+testResult.getStatus()); 
		/*
		 * //Results Integer 1 -- Test Passed 
		 *           Integer 2 -- TestFailed
		 */
		int status=testResult.getStatus();
		if(status==1)
		{
			//Close the browser
			driver.close();
		}
		else
		{
			//Take Screenshot 
			//Approach to capture screenshot of specific Element
			
			WebElement errmsg = driver.findElement(By.xpath("//*[contains(text(),'Epic sadface')]"));
		
			File outfile = ((TakesScreenshot)errmsg).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(outfile, new File("C:\\Selenium_training\\test\\src\\test\\resources\\"+testResult.getParameters()[0]+"Defect.jpeg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.close();
		}
	}

	@DataProvider(name="SD_TestData")
	public Object[][] readExcel() throws BiffException, IOException
	{
		//Open the Excel for read and write, which is available in same Project
		File f = new File("C:\\Selenium_training\\test\\src\\test\\resources\\logindata.xls");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet(0);

		int nrows = s.getRows();
		System.out.println("No.of rows = "+s.getRows());

		int ncols = s.getColumns();
		System.out.println("No.of columns = "+s.getColumns());

		//Creating an Array to store the data of an Excel sheet
		String inputData[][] = new String[nrows-1][ncols];
		int count = 0;

		for (int i=1;i<nrows;i++)
		{
			for(int j=0;j<ncols;j++)
			{
				Cell c = s.getCell(j, i);
				inputData[count][j] = c.getContents();
			}
			count++;
		}
		return inputData;


	}

}

