package project3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
/*You are asked to:
 Use the WebDriver to automatically launch and kill browsers
 Use client libraries for your favorite computer language
 Write tests in your favorite programming language using Selenium WebDriver
for testing complex
 AJAX-based web user interfaces under a Continuous Integration system */
import org.testng.annotations.Test;

public class Project3 {
	public WebDriver driver;

	@BeforeMethod
	public void set_up() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();

		// navigate to test website
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().window().maximize();

	}
	
	@AfterMethod(alwaysRun=true)
	public void tear_down()
	{
		driver.close();
	}

	@Test
	public void ajax_Demo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// wait till the calendar is loaded
		By calen = By.cssSelector("div.contentWrapper");
		By loader = By.className("raDiv");
		wait.until(ExpectedConditions.visibilityOfElementLocated(calen));

		// increment the incremental button 3 times
		for (int i = 0; i <= 3; i++) {
			// wait till the incremental button is loaded
			WebElement button = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//a[@id='ctl00_ContentPlaceholder1_RadCalendar1_NN']/span")));
			js.executeScript("arguments[0].click();", button);
			// wait till loading symbol become invisible
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		}

		// click on date
		WebElement date = driver
				.findElement(By.xpath("//table[@id='ctl00_ContentPlaceholder1_RadCalendar1_Top']/tbody/tr[4]/td[4]"));
		js.executeScript("arguments[0].click();", date);
		// wait till loading symbol become invisible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		// select another date
		WebElement date1 = driver
				.findElement(By.xpath("//table[@id='ctl00_ContentPlaceholder1_RadCalendar1_Top']/tbody/tr[3]/td[3]"));
		js.executeScript("arguments[0].click();", date1);
		// wait till loading symbol become invisible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		// capture the selected date
		WebElement text = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		System.out.println("selected date=" + text.getText());
		WebElement cleartext_button = driver.findElement(By.xpath("//span[text()='Clear Selected Dates']"));
		js.executeScript("arguments[0].click();", cleartext_button);
		// wait till loading symbol become invisible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		WebElement text1 = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		System.out.println("after clearing the text=" + text1.getText());

	}

}
