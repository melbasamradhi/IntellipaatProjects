package makemyTrip;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class plan_mytravel {

	public WebDriver driver;
	//String source_city = "Chennai";
	//String destination_city = "Delhi";
	//String dep_monYr = "March2023";
	//int dep_date = 31;
	/*String return_monYr = "May2023";
	int return_date = 5;
	String no_of_Adults = "9";
	String no_of_Children = "2";
	String no_of_infants = "4";
	String travel_Class = "Economy/Premium Economy";
	String fare_type = "Senior Citizen ";*/

//open the 'makemytrip' in the chrome browser
	@Test(priority = 1)
	public void set_Up() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}

	@Test(priority = 2)
	public void flight_search(ITestContext content) throws InterruptedException {
		Thread.sleep(3000);

// close the diwali ad
		Actions a = new Actions(driver);
		driver.switchTo().frame("notification-frame-~19713baac");
		WebElement close = driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']"));
		a.moveToElement(close).click().build().perform();
		/*
		 * driver.switchTo().frame("notification-frame-~10cb47553"); WebElement close =
		 * driver.findElement(By.id(
		 * "webklipper-publisher-widget-container-notification-close-div"));
		 * a.moveToElement(close).click().build().perform();
		 */
		driver.switchTo().defaultContent();

// close the language ad
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();

// select the 'Round trip'
		driver.findElement(By.xpath("//ul[@class='fswTabs latoBlack greyText']/li[2]")).click();

// Enter the source city name
		a.moveToElement(driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']/label")))
				.click().build().perform();
		By from = RelativeLocator.with(By.tagName("input"))
				.below(driver.findElement(By.xpath("//ul[@class='fswTabs latoBlack greyText']/li[2]")));
		WebElement fromcity = driver.findElement(from);
		String sc=content.getCurrentXmlTest().getParameter("source_city");
		a.sendKeys(sc).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();

// select the source city name from the options
		List<WebElement> source = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		int flag = 0;
		for (WebElement s : source) {
			String city = s.getText();
			if (city.contains(sc)) {
				System.out.println("Selected source city is " + city);
				s.click();
				Thread.sleep(1000);
				flag = 1;
				break;
			}
		}

//Error message is displayed,if the source city name is not correct
		if (flag != 1) {
			System.out.println("City name " + sc + " is not in the source city options");
			Assert.assertFalse(true);
		}

// Enter the destination city name
		String dc=content.getCurrentXmlTest().getParameter("destination_city");
		a.sendKeys(dc).build().perform();
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);

// select the destination city name from the options
		List<WebElement> dstn = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		int flag1 = 0;
		for (WebElement s : dstn) {
			String city = s.getText();
			if (city.contains(dc)) {
				System.out.println("Selected destination city is " + city);
				s.click();
				Thread.sleep(1000);
				flag1 = 1;
				break;
			}
		}

//Error message is displayed,if the destination city name is not correct
		if (flag1 != 1) {
			System.out.println("City name " + dc + " is not in the destination city options");
			Assert.assertFalse(true);
		}

// select the Departure Month and year
		int flag2 = 0;
		String sel_Mon;
		List<WebElement> current_mon;
		int r = 0;
		String d_MY=content.getCurrentXmlTest().getParameter("dep_monYr");
		do {
			current_mon = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));
			for (WebElement mon : current_mon) {
				sel_Mon = mon.getText();
				if (sel_Mon.equalsIgnoreCase(d_MY)) {
					flag2 = 1;
					break;
				}
			}

			if (flag2 == 0) {
				try {
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"))
							.click();
				} catch (Exception e) {

					r = 1;
					break;
				}
				Thread.sleep(1000);
			}
		} while (flag2 == 0);

// Error message if departure Month,year is not correct
		if (r == 1) {
			System.out.println("please enter the correct departure month and year");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);
		current_mon = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));

// Select the departure date
		int u = 0;
		String dd=content.getCurrentXmlTest().getParameter("dep_date");
		if ((current_mon.get(0).getText()).equalsIgnoreCase(d_MY)) {
			List<WebElement> mon1 = driver.findElements(
					By.xpath("//div[@class='DayPicker-Months']/div[1]//div[@class='DayPicker-Day']/div/p"));
			for (WebElement date : mon1) {
				if (date.getText().equalsIgnoreCase(dd)){
					u = 1;
					date.click();
					break;
				}

			}
		} else {
			List<WebElement> mon2 = driver.findElements(
					By.xpath("//div[@class='DayPicker-Months']/div[2]//div[@class='DayPicker-Day']/div/p"));
			Iterator<WebElement> i = mon2.iterator();
			while (i.hasNext()) {
				WebElement m = i.next();
				String s = m.getText();
				if (s.equalsIgnoreCase(dd)) {
					u = 1;
					m.click();
					break;
				}
			}
		}

// Error message ,when departure date is not correct
		if (u == 0) {
			System.out.println("please enter the correct departure date");
			Assert.assertTrue(false);
		}

// Select the Return Month and Year
		int r1 = 0;
		int flag5 = 0;
		String r_MY=content.getCurrentXmlTest().getParameter("return_monYr");
		do {
			current_mon = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));
			for (WebElement mon : current_mon) {
				sel_Mon = mon.getText();
				if (sel_Mon.equalsIgnoreCase(r_MY)) {
					flag5 = 1;
					break;
				}
			}
			if (flag5 == 0) {
				try {
					driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"))
							.click();
				} catch (Exception e) {
					r1 = 1;
					break;
				}
				Thread.sleep(2000);
			}
		} while (flag5 == 0);

// Error message is displayed, when return month and year are not correct
		if (r1 == 1) {
			System.out.println("please enter the correct return month and year");
			Assert.assertTrue(false);
		}
		Thread.sleep(2000);

// Select the return date
		int f = 0;
		String rd=content.getCurrentXmlTest().getParameter("return_date");
		List<WebElement> current_mon_ret;
		current_mon_ret = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']/div"));
		if ((current_mon_ret.get(0).getText()).equalsIgnoreCase(r_MY)) {
			List<WebElement> mon1 = driver.findElements(
					By.xpath("//div[@class='DayPicker-Months']/div[1]//div[@class='DayPicker-Day']/div/p"));
			for (WebElement date : mon1) {
				if (date.getText().equalsIgnoreCase(rd)) {
					f = 1;
					date.click();
					break;
				}

			}
		} else {
			List<WebElement> mon2 = driver.findElements(
					By.xpath("//div[@class='DayPicker-Months']/div[2]//div[@class='DayPicker-Day']/div/p"));
			Iterator<WebElement> i = mon2.iterator();
			while (i.hasNext()) {
				WebElement m = i.next();
				String s = m.getText();
				if (s.equalsIgnoreCase(rd)) {
					f = 1;
					m.click();
					break;
				}
			}
		}
		Thread.sleep(4000);

// Error message is displayed if return date is not correct
		if (f == 0) {
			System.out.println("please enter the correct return date");
			Assert.assertTrue(false);
		}

// select travellers and class
		driver.findElement(By.xpath("//div[@class='fsw_inputBox flightTravllers inactiveWidget ']")).click();

// select the number of adults
		String n_Ad=content.getCurrentXmlTest().getParameter("no_of_Adults");
		List<WebElement> adults = driver.findElements(By.xpath("(//div[@class='appendBottom20']//ul)[1]/li"));
		Iterator<WebElement> ad = adults.iterator();
		String no_Ad;
		while (ad.hasNext()) {
			WebElement adu = ad.next();
			no_Ad = adu.getText();
			if (no_Ad.equalsIgnoreCase(n_Ad)) {
				adu.click();
				break;
			}
		}

// select the number of children
		String n_Ch=content.getCurrentXmlTest().getParameter("no_of_Children");
		List<WebElement> children = driver.findElements(By.xpath("(//div[@class='appendBottom20']//ul)[2]/li"));
		Iterator<WebElement> ch = children.iterator();
		String no_ch;
		while (ch.hasNext()) {
			WebElement chi = ch.next();
			no_ch = chi.getText();
			if (no_ch.equalsIgnoreCase(n_Ch)) {
				chi.click();
				break;
			}
		}

// select the number of infants
		String n_in=content.getCurrentXmlTest().getParameter("no_of_infants");
		if(Integer.parseInt(n_in)<Integer.parseInt(n_Ad))
{
		List<WebElement> infants = driver.findElements(By.xpath("(//div[@class='appendBottom20']//ul)[3]/li"));
		Iterator<WebElement> in = infants.iterator();
		String no_in;
		while (in.hasNext()) {
			WebElement inf = in.next();
			no_in = inf.getText();
			if (no_in.equalsIgnoreCase(n_in)) {
				inf.click();
				break;
			}
		}
}
		
//Error message is displayed if number of infants is more than adults
else
{
	System.out.println("Number of infants cannot be more than adults");
	Assert.assertTrue(false);
}

// select the travel class
		String cl_tr=content.getCurrentXmlTest().getParameter("travel_Class");
		List<WebElement> tclass = driver.findElements(By.xpath("(//div[@class='appendBottom20']//ul)[4]/li"));
		Iterator<WebElement> tc = tclass.iterator();
		String trcl;
		int v = 0;
		while (tc.hasNext()) {
			WebElement trc = tc.next();
			trcl = trc.getText();
			if (trcl.equalsIgnoreCase(cl_tr)) {
				v = 1;
				trc.click();
				break;
			}
		}

// Error message when travel class option is not correct
		if (v == 0) {
			System.out.println("please check the travel class mentioned");
		}
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		Thread.sleep(4000);

// Select a fare type
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String ty_Fare=content.getCurrentXmlTest().getParameter("fare_type");
		List<WebElement> fare = driver.findElements(By.xpath("//ul[@class='specialFareNew']/li/p"));
		Iterator<WebElement> far = fare.iterator();
		String fare_ty;
		while (far.hasNext()) {
			WebElement farTy = far.next();
			fare_ty = farTy.getText();
		String d[]=	fare_ty.split("Fares");
			if(ty_Fare.equalsIgnoreCase(d[0].trim())) 
			{
				js.executeScript("arguments[0].click();",farTy);
				// farTy.click();
				break;
			}
		}
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		Thread.sleep(4000);

		int total = Integer.parseInt(n_Ad) + Integer.parseInt(n_in) + Integer.parseInt(n_Ch);
		int kids = Integer.parseInt(n_in) + Integer.parseInt(n_Ch);
		if (total <= 9) {
			if (ty_Fare.equalsIgnoreCase("Senior Citizen") && kids != 0 || ty_Fare.equalsIgnoreCase("Student") && kids != 0) {
				System.out.println("Only adult passengers can avail of Student or senior citizen fares");
			} else {
// take the screenshot of the flight selected page
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File target = new File("C:\\Selenium_training\\test\\src\\test\\resources\\" + "makemytrip.jpeg");
				try {
					FileUtils.copyFile(src, target);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

// take the screenshot of the suggested flight option form

				WebElement flight_option = driver.findElement(By.xpath("//div[@class='splitviewSticky makeFlex']"));
				File src1 = flight_option.getScreenshotAs(OutputType.FILE);
				File target1 = new File(
						"C:\\Selenium_training\\test\\src\\test\\resources\\" + "makemytrip_flightoption.jpeg");
				try {
					FileUtils.copyFile(src1, target1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		else {
			System.out.println(
					"For fare type other than 'Regular fare type',total number of passengers should be less than or equal to 9");
		}
	}
	
  //close the browser 
	@Test(priority = 3, alwaysRun = true) 
	public void tear_Down()
	{ driver.close();
	}
	}
 
