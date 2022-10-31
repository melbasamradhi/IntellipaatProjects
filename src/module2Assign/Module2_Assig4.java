package module2Assign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/*TC-1 Launch Edge  Browser 
TC-2 Goto Test URL https://www.google.com
TC-3 Specify Wait Time for 5 Sec
TC-4 Get the Title of Page into Console
TC-5 Close the Browser */
public class Module2_Assig4 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe")	;
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		driver.close();
	}

}
