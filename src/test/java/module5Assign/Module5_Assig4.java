package module5Assign;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*Step-1 Launch Firefox Browser
Step-2 Open Test URL https://www.jquery-az.com/javascript/demo.php?ex=151.1_1  in Chrome Browser
Step-3 Click on  Click here to show confirm alert Button 
Step-4 Get the text displayed on Alert into Console
Step-5 Accept  the Web Alert to Delete Account  
Step-6 Get the text displayed on Alert into Console 
Step-6 Accept the Alert 
Step-6 Close Browser*/
public class Module5_Assig4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.jquery-az.com/javascript/demo.php?ex=151.1_1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Click here to show confirm alert')]")).click();
		Thread.sleep(3000);
		Alert a = driver.switchTo().alert();
		String alerttext1 = a.getText();
		Thread.sleep(3000);
		System.out.println(alerttext1);
		a.accept();
		// driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String alerttext2 = a.getText();
		// String alerttext2=driver.switchTo().alert().getText();
		Thread.sleep(3000);
		System.out.println(alerttext2);
		a.accept();
		// driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.close();

	}

}
