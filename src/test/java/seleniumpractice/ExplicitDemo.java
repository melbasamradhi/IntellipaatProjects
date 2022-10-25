package seleniumpractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitDemo {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Select WORD files']")).click();
		Thread.sleep(3000);
//to put the path in clipboard
		StringSelection s= new StringSelection("C:\\Selenium_training\\upload.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
//ctrl+v..using java robot
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
//press convert into pdf
		driver.findElement(By.xpath("//button[@id='processTask']")).click();
		/*WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pickfiles']")));
		firstResult.click();*/
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement element=	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='pickfiles']")));
	element.click();
	}

}
