package module2Assign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Module2_Assig1_EdgeBrow {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe")	;
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.bigbasket.com/");
		Thread.sleep(4000);
		driver.close();

	}

}
