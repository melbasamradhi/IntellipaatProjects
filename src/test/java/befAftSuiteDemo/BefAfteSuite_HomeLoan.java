package befAftSuiteDemo;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BefAfteSuite_HomeLoan {
 @BeforeGroups("loan_Mod2")
 public void module2_setup()
	{
		System.out.println("module2 setup");
	}
 
 @AfterGroups("loan_Mod2")
 public void module2_teardown()
	{
		System.out.println("module2 teardown");
	}
 
 
	
	@BeforeTest
	public void login_module()
	{
		System.out.println("login_module--Before test..homeloan");
	}
	
	@AfterTest
	public void logout_module()
	{
		System.out.println("logout_module--After test..homeloan");
	}
	
	@Test(groups="loan_Mod1")
	public void home_module1()
	{
		System.out.println("homeloan_module1");
	}
	
	@Test(groups="loan_Mod2")
	public void home_module2()
	{
		System.out.println("homeloan_module2");
	}
	
	@Test(groups="loan_Mod3")
	public void home_module3()
	{
		System.out.println("homeloan_module3");
	}
	
	
}
