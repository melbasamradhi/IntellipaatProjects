package module7assign;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
/*
import org.openqa.selenium.By;
/*Test Scenario I:---File Download  
Step-1 Launch Firefox Browser
Step-2 Open Test URL https://www.selenium.dev/downloads/
Step-3 In Selenium Client & WebDriver Language Bindings, Click on linkText to download  Selenium with Java Language binding  
Step-4 Automate File Download    
Step-5 Close Browser*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Module7_Assig2 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		String fileDownloadPath = "C:\\Users\\melbasam";
		  
		  Map<String, Object> prefsMap = new HashMap<String, Object>();
		  
		  prefsMap.put("download.prompt_for_download", true);
		  
		  ChromeOptions option = new ChromeOptions();
		  option.setExperimentalOption("prefs", prefsMap);
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='4.4.0 (August 9, 2022)']")).click();
	//to download the file using java robot
		Robot r= new Robot();
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(5000);
		driver.close();

	}

}
