package module4Assign;
import org.openqa.selenium.By;
/*1.	Automate  Oracle  Registration Page in Chrome Browser   
    https://profile.oracle.com/myprofile/account/create-account.jspx
*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Module4_Assig2Chrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe")	;
		WebDriver driver = new ChromeDriver();
		driver.get("https://profile.oracle.com/myprofile/account/create-account.jspx");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='sView1:r1:0:email']")).sendKeys("xyz@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='sView1:r1:0:password']")).sendKeys("r4D35!ert");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='sView1:r1:0:retypePassword']")).sendKeys("r4D35!ert");
		Thread.sleep(3000);
		Select country=new Select(driver.findElement(By.xpath("//select[@name='sView1:r1:0:country']")));
		country.selectByValue("IN");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='sView1:r1:0:firstName'][@id='sView1:r1:0:firstName::content']")).sendKeys("xxxx");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:lastName::content']")).sendKeys("yyyy");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:jobTitle::content']")).sendKeys("TestEngineer");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:workPhone::content']")).sendKeys("1234567");
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:companyName::content']")).sendKeys("xxxxyyy");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:address1::content']")).sendKeys("405,Apt Apatrement");
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:address2::content']")).sendKeys("Gunjur");
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:city::content']")).sendKeys("Bangalore");
		Thread.sleep(3000); 
		Select state=new Select(driver.findElement(By.xpath("//select[@id='sView1:r1:0:state::content']")));
		state.selectByValue("16");
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//input[@id='sView1:r1:0:postalCode::content']")).sendKeys("560xxx");
		Thread.sleep(3000); 
		driver.findElement(By.xpath("//span[text()='Create Account']")).click();
		Thread.sleep(6000);
		driver.close();
		
	}
	

}
