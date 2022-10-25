package module6Assign;
/*Test Scenario I:   Actions 
Step-1 Launch Chrome Browser
Step-2 Open Test URL https://www.flipkart.com/ 
Step-3 If found any screen hiding actual page Close the Screen
Step-4  Move mouse Pointer  towards Women
Step-5  Click on Shoes
Step-6 Close Browser */

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Module6_Assig1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		WebElement fashion = driver.findElement(By.xpath("//div[text()='Fashion']"));
		Actions a = new Actions(driver);
		a.moveToElement(fashion).build().perform();
		WebElement footwear = driver.findElement(By.xpath("//a[text()='Women Footwear']"));
		a.moveToElement(footwear).build().perform();
		WebElement footwear_All = driver.findElement(By.xpath("//a[text()='All']"));
		footwear_All.click();
		String text = driver.findElement(By.xpath("//span[contains(text(),'Whether')]")).getText();
		System.out.println(text);
		driver.close();

	}

}
