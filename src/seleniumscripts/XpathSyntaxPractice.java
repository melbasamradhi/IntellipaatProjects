package seleniumscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XpathSyntaxPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
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
		
//syntax7://tagname[@locator='value')][index no]....for multimatches
		driver.findElement(By.xpath("(//input[@name='sex'])[1]")).click();
		Thread.sleep(4000);
		
//syntax8://tagname[method()='value'].......method()..is text()
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		Thread.sleep(4000);
		
		//navigate to geckodriver download website
		
		driver.navigate().to("https://firefox-source-docs.mozilla.org/testing/geckodriver/Support.html");
		Thread.sleep(5000);
		
//syntax9: //tagName[@loactor='value']/tagname[indexno]/tagname[indexno].....parent to child
		String text=driver.findElement(By.xpath("//div[@id='supported-platforms']/table[1]/tbody[1]/tr[1]/td[3]")).getText();
		System.out.println(text);
		
		
//syntax10: //tagName[@loactor='value']/tagname[indexno]//tagname[indexno]...parent to grandchild
		
		String text1=driver.findElement(By.xpath("//div[@id='supported-platforms']/table[1]/tbody[1]//td[3]")).getText();
		System.out.println(text1);
		
		driver.close();
		
		
		
		
		

	}

}
