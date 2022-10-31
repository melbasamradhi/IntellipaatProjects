package module2Assign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Module2_Assig1_firefox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe")	;
		WebDriver driver = new FirefoxDriver() ;
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(4000);
		driver.close();
	}

}
