package seleniumpractice;


	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
	import java.util.Map;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;


	public class DownloadFileDemo {

		public static void main(String[] args) throws InterruptedException, AWTException {
			 System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
		  
			  String fileDownloadPath = "C:\\Users\\melbasam";
			  
			  Map<String, Object> prefsMap = new HashMap<String, Object>();
			  
			  prefsMap.put("download.prompt_for_download", true);
			  
			  ChromeOptions option = new ChromeOptions();
			  option.setExperimentalOption("prefs", prefsMap);
			  
			  WebDriver driver  = new ChromeDriver(option);
			  driver.get("https://www.seleniumhq.org/download/");
		  	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  	  driver.manage().window().maximize();
		  	  Thread.sleep(2000);
		  	  driver.findElement(By.linkText("64 bit Windows IE")).click();
		  	  
		  	Thread.sleep(2000);
		  	//cancel the download
		  	  Robot r=new Robot();
		  	  for(int i=1;i<=4;i++)
		  	  {
		  	r.keyPress(KeyEvent.VK_TAB);
			
			r.keyRelease(KeyEvent.VK_TAB);
			
			Thread.sleep(3000);
		  	  }
		  	r.keyPress(KeyEvent.VK_ENTER);
		  	  r.keyRelease(KeyEvent.VK_ENTER);
		  	Thread.sleep(3000);
		  	driver.close();
		  	  
		  	  
			

}
	
	}
