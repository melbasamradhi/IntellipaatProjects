package Silkuli;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

public class SikuliDemo {

	public static void main(String[] args) throws InterruptedException, SikuliException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Got it']")).click();
		Thread.sleep(3000);
		Screen s= new Screen();
		s.click("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\choosefile.PNG");
		//upload file
	//	Pattern fileInput=new Pattern("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\filepath.PNG");
		//s.type(fileInput,"C:\\Selenium_training\\upload.docx");
		s.type("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\filepath.PNG","C:\\Selenium_training\\upload.docx");
		s.click("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\open.PNG");
		Thread.sleep(3000);
		driver.close();
		

	}

}
