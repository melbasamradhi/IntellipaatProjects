package module4Assign;
/*Automate  dropdowns part of Oracle  Registration Page in Firefox Browser  
https://profile.oracle.com/myprofile/account/create-account.jspx*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Module4_Assig2FF {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe")	;
		WebDriver driver = new FirefoxDriver() ;
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		Thread.sleep(3000);
		Select country=new Select(driver.findElement(By.xpath("//select[@name='sView1:r1:0:country']")));
		country.selectByValue("US");
		Thread.sleep(3000);
		Select state=new Select(driver.findElement(By.xpath("//select[@id='sView1:r1:0:state::content']")));
		state.selectByValue("36");
		Thread.sleep(3000); 
		driver.close();
	}

}
