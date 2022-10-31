package module4Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

/*Automate Facebook Registration Page  using Direct Locator's in Chrome Browser
     https://www.facebook.com/*/
public class Module4_Assig1Chrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		driver.findElement(By.name("firstname")).sendKeys("xxxx");
		driver.findElement(By.name("lastname")).sendKeys("yyyy");
		driver.findElement(By.name("reg_email__")).sendKeys("zzz@mail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("xx1234");
		Select day =new Select(driver.findElement(By.id("day")));
		day.selectByIndex(4);
		Select month =new Select(driver.findElement(By.id("month")));
		month.selectByValue("6");
		Select year =new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1990");
		
		//identify male radio button using relative locators below()
	By male=	RelativeLocator.with(By.tagName("input")).below(By.id("month"));
	driver.findElement(male).click();
	Thread.sleep(4000);
	
	//identify female radio button using relative locators toLeftOf()
	By female= RelativeLocator.with(By.tagName("input")).toLeftOf(male);
	driver.findElement(female).click();
	Thread.sleep(4000);
	
	//identify custom radio button using relative locators toRightOf()
	By custom= RelativeLocator.with(By.tagName("input")).toRightOf(male);
	driver.findElement(custom).click();
	Thread.sleep(4000);
	
	//identify year checkbox using relative locators above()
		By year1= RelativeLocator.with(By.tagName("select")).above(custom);
		Select year2=new Select(driver.findElement(year1));
		year2.selectByVisibleText("1985");
		Thread.sleep(4000);
		
		//identify privacypolicy using relative locators near()
	WebElement terms=	driver.findElement(By.linkText("Terms"));
	By policy= RelativeLocator.with(By.tagName("a")).near(terms);
	driver.findElement(policy).click();
	Thread.sleep(4000);
	
		driver.findElement(By.name("websubmit")).click();
		Thread.sleep(5000);
		driver.close();

		

	}

}
