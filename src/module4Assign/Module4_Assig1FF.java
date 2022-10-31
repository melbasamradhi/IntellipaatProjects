package module4Assign;
import org.openqa.selenium.By;
/*2.	Automate dropdowns part of Facebook Registration Page  using Direct Locator's in firefox Browser 
    https://www.facebook.com/
*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Module4_Assig1FF {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe")	;
		WebDriver driver = new FirefoxDriver() ;
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		Select day =new Select(driver.findElement(By.id("day")));
		day.selectByIndex(4);
		Select month =new Select(driver.findElement(By.id("month")));
		month.selectByValue("6");
		Select year =new Select(driver.findElement(By.id("year")));
		year.selectByVisibleText("1980");
		Thread.sleep(5000);
		driver.close();

	}

}
