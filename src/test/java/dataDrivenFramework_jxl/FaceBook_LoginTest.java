package dataDrivenFramework_jxl;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FaceBook_LoginTest {
	public WebDriver driver;
  @Test(dataProvider="inputData")
  public void login(String fName,String sName, String eMail,String pWord) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
	 driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		driver.get("https://www.facebook.com/login/");
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		driver.findElement(By.name("firstname")).sendKeys(fName);
		driver.findElement(By.name("lastname")).sendKeys(sName);
		driver.findElement(By.name("reg_email__")).sendKeys(eMail);
		driver.findElement(By.id("password_step_input")).sendKeys(pWord);
		Thread.sleep(4000);
		File target=new File("C:\\Selenium_training\\test\\src\\test\\resources\\"+fName+"default.jpeg");
		TakesScreenshot ts=  (TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		
  }
  @DataProvider(name="inputData")
  
  public Object testData() throws BiffException, IOException
  {
	  File f= new File("C:\\Selenium_training\\test\\src\\test\\resources\\logindata.xls");
Workbook w=	  Workbook.getWorkbook(f);
Sheet s=w.getSheet(1);
int column_No=s.getColumns();
int row_No=s.getRows();
	Object[][] fbdata=new Object[row_No-1][column_No] ;
	for(int i=1;i<= row_No-1;i++)
	{
		int r=i-1;
		for(int j=0;j<=column_No-1;j++)
		{
			fbdata[r][j]=s.getCell(j, i).getContents();
		}
	}
	return fbdata;
	  
  }
  
  
}
