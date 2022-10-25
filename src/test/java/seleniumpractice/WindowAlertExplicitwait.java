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

public class WindowAlertExplicitwait {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://smallpdf.com/word-to-pdf");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Got it']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[text()='Choose Files']")).click();
		Thread.sleep(5000);
//put the path of the file in the clipboard
		StringSelection s= new StringSelection("C:\\Selenium_training\\upload.docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		
//paste the path in the window ..ctrl+v..use Java Robot class
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Download']")));
		element.click();
		Thread.sleep(5000);

		

		
		driver.close();
	}

}
