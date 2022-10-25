package seleniumpractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headless_Test {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--headless");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://intellipaat.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("s")).sendKeys("Devops");
		driver.findElement(By.xpath("//form[@id='search-form']/button")).click();
		driver.findElement(By.xpath("//h3[text()='DevOps Certification Training Course']")).click();
		Thread.sleep(4000);
		String course_title = driver.findElement(By.xpath("//h1[text()='DevOps Certification Training Course']"))
				.getText();
		String expect_title = "DevOps Certification Training Course";
		if (course_title.equalsIgnoreCase(expect_title)) {
			System.out.println("Devops course page is displayed");
			driver.findElement(By.xpath("//a[text()='Fees']")).click();
			String day = driver
					.findElement(By.xpath(
							"(//div[contains(@class,'online-classroom-product')]/div//span/following::*[1]/strong)[1]"))
					.getText();
			String date = driver
					.findElement(By.xpath("//div[contains(@class,'master-time-table-weekdays-wrap')]/p/strong"))
					.getText();
			String time = driver.findElement(By.xpath("//div[contains(@class,'master-time-table-time-wrap')]/p/strong"))
					.getText();
			System.out.println("Next avaliable time slot for the devops course : Day " + day + " Date: " + date
					+ " Time: " + time);

		} else {
			System.out.println("Devops course page is not displayed ");
		}
		driver.close();

	}

}
