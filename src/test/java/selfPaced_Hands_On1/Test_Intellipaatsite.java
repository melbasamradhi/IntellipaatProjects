package selfPaced_Hands_On1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.python.modules.thread.thread;
import org.testng.annotations.Test;

/*1. To open the Intellipaat website,
2. To put a search input (e.g.: DevOps), click on search,
3. In the last search result page find a DevOps Certification Course, click on the course
4. In that last search result page see if the Course Title matches to our Desired Course Title
or not, if matches display one message and display the Next Online Class Timings for the
Course.*/

public class Test_Intellipaatsite {
	public WebDriver driver;
	
	@Test(priority=1)
public void setup() {
	System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
	 driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://intellipaat.com/");
	driver.manage().window().maximize();
	}
	
	@Test(priority=2)
	public void search() throws InterruptedException
	{
		driver.findElement(By.id("s")).sendKeys("Devops");
		driver.findElement(By.xpath("//form[@id='search-form']/button")).click();
		driver.findElement(By.xpath("//h3[text()='DevOps Certification Training Course']")).click();
	Thread.sleep(4000);
	}
	
	@Test(priority=3)
	public void validate()
	{
		String course_title=driver.findElement(By.xpath("//h1[text()='DevOps Certification Training Course']")).getText();
		String expect_title="DevOps Certification Training Course";
		if(course_title.equalsIgnoreCase(expect_title))
		{
			System.out.println("Devops course page is displayed");
			driver.findElement(By.xpath("//a[text()='Fees']")).click();
			String day=driver.findElement(By.xpath("(//div[contains(@class,'online-classroom-product')]/div//span/following::*[1]/strong)[1]")).getText();
			String date=driver.findElement(By.xpath("//div[contains(@class,'master-time-table-weekdays-wrap')]/p/strong")).getText();
			String time=driver.findElement(By.xpath("//div[contains(@class,'master-time-table-time-wrap')]/p/strong")).getText();
			System.out.println("Next avaliable time slot for the devops course : Day "+day+" Date: "+date+" Time: "+time);
			
			
		}
		else
		{
			System.out.println("Devops course page is not displayed ");
		}
		}
	
	@Test(priority=4)
	public void tear_Down()
	{
		driver.close();
	}
	}

