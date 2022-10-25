package module11Assign;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Module11Assig3_Page1 {
	public WebDriver driver;

	// constructor
	public Module11Assig3_Page1(WebDriver driver) {
		this.driver = driver;
	}

	public void enter_userName(String uName_add, String uName) throws InterruptedException, IOException {

		By user_Name = By.id(uName_add);
		driver.findElement(user_Name).sendKeys(uName);
		Thread.sleep(4000);
	}

	public void enter_password(String pwd_add, String pwd) throws InterruptedException {
		By password = By.id(pwd_add);
		driver.findElement(password).sendKeys(pwd);
		Thread.sleep(4000);
	}

	public void click_login(String log_add) throws InterruptedException {
		By login = By.id(log_add);
		driver.findElement(login).click();
		Thread.sleep(4000);
	}

}
