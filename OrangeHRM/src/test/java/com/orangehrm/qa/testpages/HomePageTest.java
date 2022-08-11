package com.orangehrm.qa.testpages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.util.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;


public class HomePageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
	initialization();
	LoginPage login=new LoginPage(driver);
	login.login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	@Test(priority=1)
	public void checkQuickLaunge() {
		homepage=new HomePage(driver);
		List<String> actualList = homepage.validatequicklaunge();
		List<String> expectedList=new ArrayList<>(Arrays.asList("Assign Leave",
				"Leave List","Timesheets","Apply Leave","My Leave","My Timesheet"));
		Assert.assertEquals(actualList,expectedList);
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}