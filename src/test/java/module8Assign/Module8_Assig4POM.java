package module8Assign;

/*Assignment-4

Write a Test Script to Automate Way2sms Login using Page Object Model */
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Module8_Assig4POM {
	public WebDriver driver;

	// constructor
	public Module8_Assig4POM(WebDriver driver) {
		this.driver = driver;

	}

	// WebElements
	By f_name = By.name("signup_name");
	By dob = By.name("signup_dob");
	By month = By.xpath("//ul[@class='pick pick-m']//i[@class='pick-i-r']");
	By date = By.xpath("//ul[@class='pick pick-d']//i[@class='pick-i-r']");
	By year = By
			.xpath("//ul[@class='pick pick-y']//div[@class='pick-arw pick-arw-s1 pick-arw-r']//i[@class='pick-i-r']");
	By dob_submit = By.xpath("//div[@class='pick-btns']");
	By mobile_No = By.name("signup_mobile");
	By email = By.name("signup_email");
	By termsandConds = By.name("sign_up_form_check");
	By submit = By.xpath("//button[text()='Submit']");

	// WebElements operation

	public void enter_fName(String fName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(f_name).sendKeys(fName);
	}

	public void click_dob() {
		driver.findElement(dob).click();
	}

	public void select_month() throws InterruptedException

	{
		WebElement mon = driver.findElement(month);
		Actions a = new Actions(driver);
		a.moveToElement(mon).build().perform();
		Thread.sleep(5000);
		for (int i = 0; i <= 5; i++) {
			a.click(mon).build().perform();
		}

	}

	public void select_date() {
		WebElement date1 = driver.findElement(date);
		Actions a = new Actions(driver);
		a.moveToElement(date1).build().perform();
		for (int i = 1; i <= 10; i++) {
			a.click(date1).build().perform();
		}
	}

	public void select_year() {
		WebElement yr = driver.findElement(year);
		Actions a = new Actions(driver);
		a.moveToElement(yr).build().perform();
		for (int i = 1; i <= 4; i++) {
			a.click(yr).build().perform();
		}
	}

	public void click_submitdob() {
		driver.findElement(dob_submit).click();
	}

	public void enter_mobNo(String phNo) {
		driver.findElement(mobile_No).sendKeys(phNo);
	}

	public void enter_email(String emailid) {
		driver.findElement(email).sendKeys(emailid);
	}

	public void click_termsCond() {
		driver.findElement(termsandConds).click();
	}

	public void click_submitButton() {
		driver.findElement(submit).click();
	}

}
