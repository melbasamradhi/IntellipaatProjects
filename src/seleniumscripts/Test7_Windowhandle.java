package seleniumscripts;
/*in the facebook signin page, click learn more,
 *  in the newtab opened click friending,
 *  come backto signin tab
 * close the tab,
 *  go to next tab and close it */
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test7_Windowhandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Learn more")).click();
		Thread.sleep(4000);
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		String window0=windows.get(0);
	String window1=	windows.get(1);
	driver.switchTo().window(window1);
	driver.findElement(By.linkText("Friending")).click();
	Thread.sleep(4000);
	driver.switchTo().window(window0);
	Thread.sleep(4000);
	driver.close();
	driver.switchTo().window(window1);
	Thread.sleep(4000);
	driver.close();
	

	}

}
