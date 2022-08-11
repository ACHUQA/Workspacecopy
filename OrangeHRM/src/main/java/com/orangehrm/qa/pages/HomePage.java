package com.orangehrm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ohrm.qa.util.TestBase;

public class HomePage extends TestBase {
	
	public HomePage(WebDriver driver)
	{
		TestBase.driver=driver;
		
	}
	
//by locators
	By quicklaungecontainer=By.xpath("//table[@class='quickLaungeContainer']//td/a");
	By performance=By.xpath("//a[@id='menu__Performance']");
	
public List<String> validatequicklaunge() {
	
	List<WebElement> welcomelist = driver.findElements(quicklaungecontainer);
	List<String> liststring=new ArrayList<>();//creating list of string 
	//to add all text of welcome//
   for(WebElement e:welcomelist) {
	   String text = e.getText();
	   liststring.add(text);
   }
   return liststring;
}
public PerformancePage clickOnPerformance() {
	   driver.findElement(performance).click();
	   return new PerformancePage(driver);
	}

}
	
