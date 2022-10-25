package project4;
/*Problem Statement 2:
• Do login and validate if Login is successful.
• Search for ‘iPhone 12’ and select a 64GB phone on product details page after
selecting the phone from product listing page.
• Add the product to cart and validate if the product added and available in Cart.
• Add a new address for shipping and proceed to checkout page then validate it.
• Same test to be repeated on Chrome browser (assuming you’re using Firefox as
default browser else vice-versa).
• Any actions in any page are welcome (like sorting the products in product listing
page, page header assertions in each page to validate if on right page, etc).*/
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Project4_prob2_Testcase_FF {
	public static WebDriver driver;
	Project4_prob2_page1_POM login;
	Project4_prob2_page2_POM cart;
	Project4_prob2_page3_POM checkout;
	Project4_prob2_page4_POM address;
	Project4_prob2_page5_POM consalidated_Bill;
	Project4_prob2_page6_POM conf_msg;
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe")	;
		 driver = new FirefoxDriver() ;
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();	
			Thread.sleep(5000);
			Project4_prob2_page1_POM login=new Project4_prob2_page1_POM(driver);
			Project4_prob2_page2_POM cart =new Project4_prob2_page2_POM(driver);
			Project4_prob2_page3_POM checkout=new Project4_prob2_page3_POM(driver);
			Project4_prob2_page4_POM address=new Project4_prob2_page4_POM(driver);
			Project4_prob2_page5_POM consalidated_Bill=new Project4_prob2_page5_POM(driver);
			Project4_prob2_page6_POM conf_msg=new Project4_prob2_page6_POM(driver);
			
			login.enter_Username("standard_user");
			login.enter_password("secret_sauce");
			login.click_login();
			Thread.sleep(5000);
			
			cart.click_addtocart();
			cart.click_cart();
			Thread.sleep(5000);
			
			checkout.click_checkoutbutton();
			Thread.sleep(5000);
			
			address.enter_firstname("xxxx");
			address.enter_lastname("yyyy");
			address.enter_postalcode("1234");
			address.click_continuebutton();
			Thread.sleep(5000);
			
			consalidated_Bill.click_finishbutton();
			Thread.sleep(5000);
			
			conf_msg.get_confirmationMsg();
			conf_msg.take_Screenshot();
			conf_msg.click_backHomebutton();
			Thread.sleep(5000);
			driver.close();
		}
	}


