package seleniumpractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaRobotDemo {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.vertex42.com/ExcelTemplates/yearly-calendar.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
//to open new tab using robot class..press  Ctrl+t		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
//to close the current tab...press Ctrl+w
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_W);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
//to open new window using robot class..press  Ctrl+n
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
//to open new tab using robot class..press  Ctrl+t		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
//to close everything using robot class..press alt+f4
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_F4);
		r.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(5000);
//to scrolldown using robot class...press pagedown		
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(5000);
//to scrollup using robot class...press pageup		
		r.keyPress(KeyEvent.VK_PAGE_UP);
		r.keyRelease(KeyEvent.VK_PAGE_UP);
		Thread.sleep(5000);

		driver.navigate().to("https://www.vertex42.com/Files/download2/themed.php?file=2022-calendar.xlsx");
		driver.findElement(By.xpath("//a[text()='⤓ Download']")).click();
	}

}
