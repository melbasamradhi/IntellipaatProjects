package pageOM_Demo;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class POM_ninjaloginTestcase {
	WebDriver driver;
	POM_ninjalogin login;

	@BeforeMethod
	public void set_up() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");
	}

	@Test(dataProvider = "inputData")
	public void login_data(String fName, String lName, String eMail, String phNo, String pWord, String subscr)
			throws InterruptedException {
		login = new POM_ninjalogin(driver);
		login.enter_firstName(fName);
		login.enter_lastName(lName);
		login.enter_mailid(eMail);
		login.enter_phoneNo(phNo);
		login.enter_pwrd(pWord);
		login.reenter_pwrd(pWord);
		login.subscription(subscr);
		Thread.sleep(7000);
	}

	@AfterMethod
	public void tear_Down(ITestResult result) {
		// takescreenshot
		File target = new File(
				"C:\\Selenium_training\\test\\src\\test\\resources\\" + result.getParameters()[0] + "default.jpeg");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.close();
	}

	@DataProvider(name = "inputData")
	public Object login_Data() throws BiffException, IOException {
		File f = new File("C:\\Selenium_training\\test\\src\\test\\resources\\logindata.xls");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet(2);
		int No_colum = s.getColumns();
		int No_rows = s.getRows();
		Object[][] data = new Object[No_rows - 1][No_colum];
		for (int i = 1; i <= No_rows - 1; i++) {
			int r = i - 1;
			for (int j = 0; j <= No_colum - 1; j++) {
				data[r][j] = s.getCell(j, i).getContents();
			}
		}

		return data;

	}

}
