package befAftSuiteDemo;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BefAfteSuite_CarLoan {
	@BeforeSuite
	public void set_up()
	{
		System.out.println("set_up...before suite");
	}
	
	@AfterSuite
	public void tear_Down()
	{
		System.out.println("tear_Down...after suite");
	}
	 @BeforeGroups("loan_Mod1")
	 public void module1_setup()
		{
			System.out.println("module1 setup");
		}
	 
	 @AfterGroups("loan_Mod1")
	 public void module1_teardown()
		{
			System.out.println("module1 teardown");
		}
	 
	
	@BeforeTest
	public void login_module()
	{
		System.out.println("login_module--Before test...carloan");
	}
	
	@AfterTest
	public void logout_module()
	{
		System.out.println("logout_module--After test...carloan");
	}
	
	@Test(groups="loan_Mod1")
	public void car_module1()
	{
		System.out.println("carloan_module1");
	}
	
	@Test(groups="loan_Mod2")
	public void car_module2()
	{
		System.out.println("carloan_module2");
	}
	
	@Test(groups="loan_Mod3")
	public void car_module3()
	{
		System.out.println("carloan_module3");
	}
	
	
	
	
	
	
}
