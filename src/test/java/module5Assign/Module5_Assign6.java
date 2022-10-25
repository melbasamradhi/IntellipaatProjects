package module5Assign;

import org.openqa.selenium.By;
/* Step-1 Launch ChromeBrowser
	Step-2 Open Test URL http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm  in Chrome Browser
	Step-3 Switch into 0th  Frame 
	Step-3 Get plain text into Console You've found my HTML tutorial site, which is my final year computing project.
	Step-4 Switch into 1st  Frame
	Step-5 Clear text from Browser and versions: Text box 
	Step-6 Send text into Browser and versions: Text box 
	Step-7 Get given input into Console from Browser and versions: Text Box 
        Step-8 Switch into 2nd  Frame
        Step-9 Get plain text into Console A Tag in HTML denotes certain.............
        Step-10 Close Browser  */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Module5_Assign6 {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.maths.surrey.ac.uk/explore/nigelspages/frame2.htm");
		Thread.sleep(3000);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		String text1 = driver.findElement(By.xpath("//p[starts-with(text(),'You')]")).getText();
		System.out.println(text1);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		Thread.sleep(3000);
		WebElement textBox = driver
				.findElement(By.xpath("//form[@name='test']/table[1]/tbody[1]/tr[2]/td[2]/textarea"));
		textBox.clear();
		textBox.sendKeys("Text Box");
		System.out.println(textBox.getAttribute("value"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2);
		Thread.sleep(3000);
		String text2 = driver.findElement(By.xpath("//form[@name='menuform']/table/tbody/tr/td[2]/p[2]/font"))
				.getText();
		System.out.println(text2);
		driver.close();

	}

}
