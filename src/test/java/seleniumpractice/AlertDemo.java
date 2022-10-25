package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/javascript/demo.php?ex=151.1_1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Click here to show confirm alert')]")).click();
		Thread.sleep(3000);
		String alerttext1=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		System.out.println(alerttext1);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String alerttext2=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		System.out.println(alerttext2);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
	driver.close();
	}

}
