package module7assign;
/*Test Scenario I:
Test Scenario IV:---File Download
1. Launch https://launchpad.net/sikuli  in Firefox Browser
2. Click  on sikulixsetup-1.1.2.jar  to Download
3. Go to Window Alert and Select  Save 
4. Specify Wait  
5. Close Site*/

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Module7_Assig3 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		 String fileDownloadPath = "C:\\Users\\melbasam";
		  
		  Map<String, Object> prefsMap = new HashMap<String, Object>();
		  
		  prefsMap.put("download.prompt_for_download", true);
		  
		  ChromeOptions option = new ChromeOptions();
		  option.setExperimentalOption("prefs", prefsMap);
		  
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://launchpad.net/sikuli/obsolete/1.1.2");
		driver.findElement(By.xpath("//a[text()='sikulixsetup-1.1.2.jar']")).click();
//to select cancel		
		Robot r= new Robot();
		/*Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		driver.close();*/
//to select save
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.close();
	}

}
