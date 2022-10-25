package befAftSuiteDemo;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BefAfteSuite_PersonalLoan {
	 @BeforeGroups("loan_Mod3")
	 public void module3_setup()
		{
			System.out.println("module3 setup");
		}
	 
	 @AfterGroups("loan_Mod3")
	 public void module3_teardown()
		{
			System.out.println("module3 teardown");
		}
	@BeforeTest
	public void login_module()
	{
		System.out.println("login_module--Before test..personalloan");
	}
	
	@AfterTest
	public void logout_module()
	{
		System.out.println("logout_module--After test..personalloan");
	}
	
	@Test(groups="loan_Mod1")
	public void personal_module1()
	{
		System.out.println("personalloan_module1");
	}
	
	@Test(groups="loan_Mod2")
	public void personal_module2()
	{
		System.out.println("personalloan_module2");
	}
	
	@Test(groups="loan_Mod3")
	public void personal_module3()
	{
		System.out.println("personalloan_module3");
	}
	
}
