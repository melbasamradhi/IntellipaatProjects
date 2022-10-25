package module5Assign;
/*Automate Facebook Registration Page  using Relative X-path  in Edge Browsers
https://www.facebook.com/ */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Module5_Assig3Edge {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe")	;
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/login/");
		Thread.sleep(4000);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		Thread.sleep(4000);
		 //Syntax1: //tagname[@locator='value']
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("xxxx");
		Thread.sleep(4000);
		
//syntax2: //*[locator='value']
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("yyyy");
		Thread.sleep(4000);

//syntax3: //tagname[starts-with(method1,'value')] ......method1 is @locator or text()
		driver.findElement(By.xpath("//input[starts-with(@name,'reg')]")).sendKeys("8456378");
		Thread.sleep(4000);
		
//syntax4: //tagname[@locator='value'][@locator='value']...........and operation
		driver.findElement(By.xpath("//input[@name='reg_passwd__'][@id='password_step_input']")).sendKeys("1234");
		Thread.sleep(4000);
		
//syntax5: //tagname[@locator='value' or @locator='value']
		Select day= new Select(driver.findElement(By.xpath("//select[@id='day' or @name='birthday_day']")));
		day.selectByIndex(4);
		Thread.sleep(4000);
		
//synax6: //tagname[contains(method1,'value')].....method1 is text() or @locator
		Select month= new Select(driver.findElement(By.xpath("//select[contains(@id,'month')]")));
		month.selectByValue("3");
		Thread.sleep(4000);
		
		Select year= new Select(driver.findElement(By.xpath("//select[@id='year'][@name='birthday_year']")));
		year.selectByVisibleText("1995");
		Thread.sleep(4000);
		
//syntax7:(//tagname[@locator='value')][index no]....for multimatches
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		Thread.sleep(4000);
		
//syntax8://tagname[method()='value'].......method()..is text()
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(4000);
		driver.close();

		

	}

}
