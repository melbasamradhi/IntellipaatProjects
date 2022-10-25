package testNG_Basic;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Testng_plainjava {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		String expected_URL="https://www.saucedemo.com/inventory.html";
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		String actual_URL=driver.getCurrentUrl();
		if(actual_URL.contains(expected_URL))
		{
			System.out.println("login success-Test case passed");
		}
		else
		{
			System.out.println("login not success-Test case failed");
		}
		driver.close();
	}

}
