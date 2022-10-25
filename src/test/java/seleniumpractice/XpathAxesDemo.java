package seleniumpractice;
/* Preceding
Following
Ancestor
Descendant
Preceding  sibling
Following sibling
parent
child*/

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxesDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		WebElement search=driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("current time");
		search.sendKeys(Keys.ENTER);
	String time=	driver.findElement(By.xpath("//h2[text()='Local Time']/following::*[2]")).getText();
	System.out.println(time);
	
	String day=	driver.findElement(By.xpath("//h2[text()='Local Time']/following::*[2]/following-sibling::*[1]")).getText();
	System.out.println(day);
	//h2[text()='Local Time']/following::*[2]/following-sibling::*[1]/child::*[1]
	String year=	driver.findElement(By.xpath("//h2[text()='Local Time']/following::*[2]/following-sibling::*[1]/child::*[1]")).getText();
	System.out.println(year);
	
	
	String timezone=	driver.findElement(By.xpath("//span[contains(text(),'Time')]/preceding::*[1]")).getText();
	System.out.println(timezone);	
	String time2=	driver.findElement(By.xpath("//span[contains(text(),'Time')]/preceding-sibling::*[2]")).getText();
	System.out.println(time2);	
	
	String currentTime=	driver.findElement(By.xpath("//span[contains(text(),'Time')]/parent::*[1]")).getText();
	System.out.println(currentTime);	
	//div[@id='qlook']/preceding::*[1]
	driver.findElement(By.xpath("//h3[text()='Time in India']")).click();
	String sunandmoon=	driver.findElement(By.xpath("//div[@id='qlook']/preceding::*[1]")).getText();
	System.out.println(sunandmoon);	
	//div[@id='qlook']/child::*[3]/following::*[23]
	String localtime=	driver.findElement(By.xpath("//div[@id='qlook']/child::*[2]")).getText();
	System.out.println(localtime);
	String currentday=	driver.findElement(By.xpath("//div[@id='qlook']/child::*[3]")).getText();
	System.out.println(currentday);
	String dialcode=	driver.findElement(By.xpath("//div[@id='qlook']/child::*[3]/following::*[23]")).getText();
	System.out.println(dialcode);
	//div[@id='qlook']/child::*[3]/following::*[23]/parent::*[1]
	String country_Abbrevation=	driver.findElement(By.xpath("//div[@id='qlook']/child::*[3]/following::*[23]/parent::*[1]/child::*[3]")).getText();
	System.out.println(country_Abbrevation);
	//div[@id='qlook']/child::*[3]/following::*[23]/parent::*[1]/child::*[last()-1]
	String noOfTimeZones=	driver.findElement(By.xpath("//div[@id='qlook']/child::*[3]/following::*[23]/parent::*[1]/child::*[last()-1]")).getText();
	System.out.println(noOfTimeZones);
	driver.close();
	
	}

}
