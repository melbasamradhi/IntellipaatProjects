package seleniumpractice;

/*    */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		Thread.sleep(5000);
// click org.openqa.selenium inside frame(0)
		driver.switchTo().frame(0);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='org.openqa.selenium']")).click();
		Thread.sleep(5000);
//comeout of frame...
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
//click Alert in Frame(1)
		driver.switchTo().frame(1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		Thread.sleep(5000);
//comeout of frame...
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
//click Tree in Frame(2)
		driver.switchTo().frame("classFrame");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Tree']")).click();
		Thread.sleep(5000);
		String text = driver.findElement(By.xpath("//h1[starts-with(text(),'Hierarchy')]")).getText();
		System.out.println(text);
		driver.close();

	}

}
