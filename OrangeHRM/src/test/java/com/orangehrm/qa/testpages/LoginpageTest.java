package com.orangehrm.qa.testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.util.TestBase;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;

public class LoginpageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	public LoginpageTest() throws IOException
	{
		super();
	}
	

	@BeforeMethod
	public void setUp()
	{
	initialization();
	 login=new LoginPage(driver);
	 }
	@Test(priority=1)
	public void loginPageTitle()
	{
   String title=login.validatePageTitle();
   Assert.assertEquals(title, "OrangeHRM");
   }
	@Test(priority=2)
	public void imgLogoDisplayed() {
		boolean flag = login.imgLogo();
		Assert.assertTrue(flag);
	}
	@Test (priority=3)
	public void login()
	{
	     homepage=new HomePage(driver);
	     homepage= login.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
 @AfterMethod
	public void tearDown()
	{
		driver.quit();

}
}