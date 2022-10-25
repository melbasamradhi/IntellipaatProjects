package module6Assign;

/* Assignment-4

Test Scenario I:   Actions 
Step-1 Launch Chrome Browser
Step-2 Open Test URL http://only-testing-blog.blogspot.com/2014/09/selectable.html
Step-3 Drag the Slider up to 50% and drop the Slider  
Step-4 Close Browser*/
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Module6_Assig4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("http://only-testing-blog.blogspot.com/2014/09/selectable.html");
		driver.manage().window().maximize();
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']"));
		Actions a = new Actions(driver);
		a.dragAndDropBy(slider, 50, 0).build().perform();
		Thread.sleep(5000);
		driver.close();

	}

}
