package module11Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* logout in page2*/
public class Module11Assig2_Page2 {
	public WebDriver driver;
	public Module11Assig2_Page2(WebDriver driver)
	{
		this.driver=driver;
		
	}
	//webelement
	By menu= By.xpath("//button[@id='react-burger-menu-btn']");
	By logout_button=By.xpath("//a[text()='Logout']");
	
	//operations
	public void  click_Menu()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		driver.findElement(menu).click();
	}
	
	public void  click_logout()
	{
		driver.findElement(logout_button).click();
	}
	

}
