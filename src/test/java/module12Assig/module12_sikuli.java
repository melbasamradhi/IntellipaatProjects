package module12Assig;
/*Assignment-4

Test Scenario I:  Use Sikuli 
Step-1 Launch Firefox Browser
Step-2 Open Test URL https://smallpdf.com/word-to-pdf
Step-3 Click on ChooseFile Button
Step-4 Automate Window Alert by Uploading File  
Step-5 Specify webDriver Wait to Complete file Conversion and Download button get's displayed 
Step-6 Click on Download Button
Step-5 Close Browser*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class module12_sikuli {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe")	;
		WebDriver driver = new FirefoxDriver() ;
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Got it']")).click();
		Thread.sleep(3000);
		Screen s= new Screen();
		s.click("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\choosefile.PNG");
		//upload file
		Pattern fileInput=new Pattern("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\filepath.PNG");
		s.type(fileInput,"C:\\Selenium_training\\upload.docx");
		Thread.sleep(5000);
		s.click("C:\\Selenium_training\\sikuli\\src\\test\\resources\\sikuliLocator\\open.PNG");
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(25));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.iirit6-0:nth-child(2) > button:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > svg:nth-child(1)")));
		element.click();
		Thread.sleep(5000);
		driver.close();
		

	}

}
