package com.orangehrm.qa.pages;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ohrm.qa.util.TestBase;

public class PerformancePage extends TestBase{
	
	public PerformancePage(WebDriver driver) {
		this.driver=driver;
	} 
	
	By configure=By.xpath("//a[@id='menu_performance_Configure']");
	By configure_select=By.xpath("//a[@id='menu_performance_Configure']/following::ul/li/a[1]");
	
	
  
	public void clickonConfigure() {
	  driver.findElement(configure).click();
	}
	
	public void selectConfigure()
	{
		List<WebElement> configure_elements = driver.findElements(configure_select);
		for(WebElement e:configure_elements)
		{
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase("Trackers"))
			{
				e.click();
				break;
			}
		}
	}
		public void clickCheckList(String name)
		{
			driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::"
					+ "td/input[@name='chkSelectRow[]']")).click();

			
		}

	
	}

	/*
	 * By Grace=By.
	 * xpath("//a[text()='Garry White']/parent::td/preceding-sibling::td/input[@name='chkSelectRow[]']"
	 * ); By Russel=By.
	 * xpath("//a[text()='Russel Hamilton']/parent::td/preceding-sibling::td/input[@name='chkSelectRow[]']"
	 * ); By Sara_Tencrady=By.
	 * xpath("//a[text()='Sara Tencrady']/parent::td/preceding-sibling::td/input[@name='chkSelectRow[]']"
	 * ); By Tasmimapriya=By.
	 * xpath("//a[text()='Tasmimapriya Rimasalunke']/parent::td/preceding-sibling::td/input[@name='chkSelectRow[]']"
	 * ); By SelectAll_Employee=By.
	 * xpath("//table[@class='table hover']//th/input[@name='chkSelectAll']");
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */