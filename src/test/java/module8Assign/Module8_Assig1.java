package module8Assign;

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

/*Test Scenario I:  File Upload
Step-1 Launch Chrome Browser
Step-2 Open Test URL https://smallpdf.com/word-to-pdf
Step-3 Click on ChooseFile Button
Step-4 Automate Window Alert by Uploading File  
Step-5 Specify java Wait to Complete file Conversion and Download button get's displayed 
Step-6 Click on Download Button
Step-5 Close Browser*/
public class Module8_Assig1 {

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
		
//java wait
		Thread.sleep(60000);
		WebElement element=driver.findElement(By.xpath("//span[text()='Download']"));
		element.click();
		Thread.sleep(5000);
		driver.close();
		

	}

}
