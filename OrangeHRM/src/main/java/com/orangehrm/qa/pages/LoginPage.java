package com.orangehrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ohrm.qa.util.TestBase;

public class LoginPage extends TestBase {

	public LoginPage(WebDriver driver)
	{
		TestBase.driver=driver;
	}
	//By locators
	By username=By.name("txtUsername123");
	By password=By.name("txtPassword145");
	By login=By.xpath("//input[@id='btnLogin']");	
	By orangelogo=By.xpath("//div[@id='divLogo']/img[1]");
  
//action methods 
	public String validatePageTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	public boolean imgLogo() {
	   return driver.findElement(orangelogo).isDisplayed();
	   
	}
	public HomePage login(String uname, String pwd)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
		return new HomePage(driver);
	}
}
