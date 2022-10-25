package befAftSuiteDemo;

import org.testng.annotations.Test;

public class BefAfteSuite_groupMethod {
	@Test(groups="login_mod")
	public void module_in1()
	{
		System.out.println("module1_in");
	}
	
	@Test(groups="login_mod")
	public void module_in2()
	{
		System.out.println("module2_in");
	}
	@Test(groups="login_mod")
	public void module_in3()
	{
		System.out.println("module3_in");
	}
	@Test(groups="logout_mod")
	public void module_out1()
	{
		System.out.println("module1_out");
	}
	@Test(groups="logout_mod")
	public void module_out2()
	{
		System.out.println("module2_out");
	}
	
	@Test(groups="logout_mod")
	public void module_out3()
	{
		System.out.println("module3_out");
	}
	
	
}
