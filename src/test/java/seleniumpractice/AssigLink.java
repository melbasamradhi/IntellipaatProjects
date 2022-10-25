package seleniumpractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssigLink {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		Thread.sleep(6000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		
		//link
			/*	WebElement link=	driver.findElement(By.linkText("Software Testing Tutorials"));
				System.out.println(link.getAttribute("href"));
			driver.get(link.getAttribute("href"));
				Thread.sleep(5000);
				driver.navigate().back();
				
				Thread.sleep(5000);	*/
				
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("xxx");
		Thread.sleep(3000);
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("yyy");
		Thread.sleep(3000);
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("123");
		Thread.sleep(3000);
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("rrrr");
		Thread.sleep(3000);
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("ffff");
		Thread.sleep(3000);
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("xxx@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Wednesday']")).click();
		Thread.sleep(3000);
		Select s= new Select(driver.findElement(By.id("RESULT_RadioButton-9")));
		s.selectByValue("Radio-0");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(3000);
		for(int i=1;i<=4;i++)
		{
		driver.findElement(By.xpath("//span[text()='Prev']")).click();
		Thread.sleep(3000);
		}
		driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']/tbody//tr[3]/td[5]")).click();
		Thread.sleep(3000);	
	WebElement date=	driver.findElement(By.id("datepicker"));
	System.out.println(date.getAttribute("value"));
	driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	Thread.sleep(3000);	
	driver.switchTo().alert().accept();
	Thread.sleep(3000);
	String alertresponse=driver.findElement(By.xpath("//p[@id='demo']")).getText();
	System.out.println(alertresponse);
	driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
	Thread.sleep(3000);
	driver.findElement(By.className("wikipedia-search-button")).click();
	Thread.sleep(3000);
	List<WebElement> searchRes=driver.findElements(By.xpath("//div[@id='wikipedia-search-result-link']"));
	System.out.println(searchRes.size());
	for(int i=0;i<searchRes.size();i++)
	{
		System.out.println(searchRes.get(i).getText());
	}
	String text=driver.findElement(By.xpath("//div[@class='widget-content']/table/tbody/tr[6]/td[3]")).getText();
	System.out.println(text);
	}
	

}
