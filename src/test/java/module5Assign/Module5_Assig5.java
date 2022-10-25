package module5Assign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Step-1 Launch Firefox Browser
	Step-2 Open Test URL https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt  in Chrome Browser
	Step-3 Switch into Frame 
	Step-3 Click on  Try it  Button 
	Step-4 Send the text into Alert 
	Step-5 Accept  the Web Alert 
	Step-6 Get the text displayed on page into Console 
	Step-7 Close Browser	*/
public class Module5_Assig5 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		Thread.sleep(3000);
		driver.switchTo().frame("iframeResult");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("hello");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		driver.close();
	}

}
