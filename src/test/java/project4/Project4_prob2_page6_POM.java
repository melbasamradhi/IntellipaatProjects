package project4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Project4_prob2_page6_POM {
	public WebDriver driver;

	// constructor
	public Project4_prob2_page6_POM(WebDriver driver) {
		this.driver = driver;
	}

	// Webelements on page 6 of suacedemo labs

	By backHome_button = By.xpath("//button[text()='Back Home']");
	By image = By.xpath("//img[@class='pony_express']"); 
	By confirmation_message = By.xpath("//div[@class='complete-text']");

// operation on the webelements

	public void get_confirmationMsg() {
		String conf_Msg = driver.findElement(confirmation_message).getText();
		System.out.println(conf_Msg);
	}

	public void take_Screenshot() {
		File target = new File("C:\\Selenium_training\\test\\src\\test\\resources\\" + "project4img.jpeg");
		File img = driver.findElement(image).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(img, target);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void click_backHomebutton() {
		driver.findElement(backHome_button).click();
	}

}
