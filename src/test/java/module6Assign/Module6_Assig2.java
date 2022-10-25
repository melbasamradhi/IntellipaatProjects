package module6Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/*Test Scenario I:   Actions 
Step-1 Launch Chrome Browser
Step-2 Open Test URL http://only-testing-blog.blogspot.com/2014/09/selectable.html
Step-4  Double Click on Double-Click Me To See Alert Button  to generate Alert
Step-5  Accept Alert 
Step-6 Close Browser*/
public class Module6_Assig2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("http://only-testing-blog.blogspot.com/2014/09/selectable.html");
		driver.manage().window().maximize();
		WebElement button = driver.findElement(By.xpath("//button[contains(text(),'Double')]"));
		Actions a = new Actions(driver);
		a.doubleClick(button).build().perform();
		Thread.sleep(5000);
		String alert_Text = driver.switchTo().alert().getText();
		System.out.println(alert_Text);
		driver.switchTo().alert().accept();
		driver.close();
	}

}
