package com.orangehrm.qa.testpages;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.util.TestBase;
import com.ohrm.qa.util.TestUtil;
import com.orangehrm.qa.pages.HomePage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.PerformancePage;

public class PerformancePageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	PerformancePage perform;

	 TestUtil testutil;
	public PerformancePageTest()
	{
		super();
	}
	@BeforeMethod
    public void setup()
    {
    	initialization();
    	login=new LoginPage(driver);
    	homepage=new HomePage(driver);
    	
    login.login(prop.getProperty("username"), prop.getProperty("password"));
    	 }
    @Test (priority=1)
	public void goToConfigure() {
    
	 perform=new PerformancePage(driver);
	   testutil=new TestUtil();
	   testutil.sleep();
	    perform=homepage.clickOnPerformance();
	    perform.clickonConfigure();
	    perform.clickonConfigure();
	    perform.selectConfigure();
	    perform.clickCheckList("Garry White");
	    perform.clickCheckList("Russel Hamilton");
	    perform.clickCheckList("Sara Tencrady");
	    perform.clickCheckList("Tasmimapriya Rimasalunke");
	
	}
   
	
	}
