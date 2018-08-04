package com.hrm.qa.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.Loginpage;
import com.hrm.qa.testutil.Customlistener;
@Listeners(Customlistener.class)
public class LoginpageTest  extends TestBase{
	
	Loginpage loginpage;
	
	
	public LoginpageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage = new Loginpage();
	}
	
	@Test(priority =1)
	public void Logotest()
	{
		 boolean b = loginpage.checkhrmlogo();
		 Assert.assertEquals(b, true);
	
	}
	
	@Test(priority=2)
	public void Titletest()
	{
		
		String tiltle = loginpage.validateTitle();
		Assert.assertEquals(tiltle, "OrangeHRM");
	}
	@Test(priority=3)
	public void logintest()
	{
		loginpage.Login("username", "password");
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
