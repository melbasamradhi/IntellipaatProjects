package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AdvUserInteraction2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement button=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		Actions a= new Actions(driver)	;
		a.doubleClick(button).build().perform();
	System.out.println(driver.findElement(By.id("field2")).getAttribute("value"));
		
	WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement drop=driver.findElement(By.xpath("//div[@id='droppable']"));
	a.dragAndDrop(drag,drop).build().perform();
	System.out.println(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText());
	WebElement drag1=driver.findElement(By.xpath("//h5[text()='Mr John']//following::*[1]"));
	WebElement drag2=driver.findElement(By.xpath("//h5[text()='Mary']//following::*[1]"));
	WebElement drop1=driver.findElement(By.id("trash"));
	a.dragAndDrop(drag1, drop1).build().perform();
	a.dragAndDrop(drag2, drop1).build().perform();
	Thread.sleep(5000);
	WebElement slider=driver.findElement(By.id("slider"));
	a.dragAndDropBy(slider,50,0).build().perform();
	Thread.sleep(5000);
	//div[@id='resizable']/child::*[4]
	WebElement resize=driver.findElement(By.xpath("//div[@id='resizable']/child::*[4]"));
	
	a.clickAndHold(resize).moveByOffset(5,5).release().build().perform();
	}

}
