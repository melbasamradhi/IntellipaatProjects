package dataDrivenFramework_jxl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot_WebElement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

			//Goto Test URL https://www.saucedemo.com/
			driver.get("https://www.saucedemo.com/");
			Thread.sleep(5000);

			//UserName
			driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("username");
			Thread.sleep(5000);	

			//Password
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pwd");
			Thread.sleep(5000);	

			//LOGIN Button
			driver.findElement(By.xpath("//input[@id='login-button']")).click();
			Thread.sleep(5000);	
			WebElement errmsg = driver.findElement(By.xpath("//*[contains(text(),'Epic sadface')]"));
		String s="testing";
		//screenshot of webelement...the error message	
			File outfile = errmsg.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(outfile, new File("C:\\Selenium_training\\test\\src\\test\\resources\\"+s+"Defect.jpeg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driver.close();


	}

}
