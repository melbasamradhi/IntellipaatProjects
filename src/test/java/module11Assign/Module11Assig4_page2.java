package module11Assign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Module11Assig4_page2 {
	public WebDriver driver;
	public Module11Assig4_page2(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void  click_Menu(String clickmenu_addr) throws InterruptedException
	{
		By menu= By.xpath(clickmenu_addr);
		
		driver.findElement(menu).click();
		Thread.sleep(5000);
	}
	
	public void  click_logout(String logou_addre) throws InterruptedException
	{
		By logout_button=By.xpath(logou_addre);
		driver.findElement(logout_button).click();
		Thread.sleep(5000);
	}
	


}
