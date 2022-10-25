package module10Assig;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Module10_Assig5 {
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
	
	@Test(priority=1)
	public void car_module1()
	{
		System.out.println("carloan_module1");
	}
	
	@Test(priority=2)
	public void car_module2()
	{
		System.out.println("carloan_module2");
	}
	
	@Test(priority=3)
	public void car_module3()
	{
		System.out.println("carloan_module3");
	}
	
	
}
