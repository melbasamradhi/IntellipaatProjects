package module10Assig;
/*Write a TestScript to execute Test Suite  in Maven */

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Module10_Assig1 {
	@BeforeClass
	public void set_Up()
	{
		System.out.println("setup.......Before class");
	}
	
	@AfterClass
	public void tear_Down()
	{
		System.out.println("tearDown.....After class");
	}
	
  @Test(priority=1)
  public void method1_Login() {
	  System.out.println("Method 1...login");
  }
  
  @Test(priority=2,dependsOnMethods="method1_Login")
  public void method2_enterData() {
	  System.out.println("Method 2...enterData");
  }
  
  @Test(priority=3,dependsOnMethods="method2_enterData")
  public void method3_Logout() {
	  System.out.println("Method 3...logout");
  }
  
  @Test(priority=4,alwaysRun=true)
  public void method4_cleanUp() {
	  System.out.println("Method 4...cleanUp");
  }
 
  
}
