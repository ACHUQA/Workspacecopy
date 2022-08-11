package com.ohrm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static  WebDriver driver; //global variable 
	public static Properties prop;//global variable 
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase()
	{
				try {
					prop=new Properties();
					FileInputStream fis=new FileInputStream("C:/Users/HP/eclipse-workspace/OrangeHRM/src/main/java/com/ohrm/qa/config/configure1.properties");
					prop.load(fis);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		
	

	public  void initialization()
	{
	
		String browserName = prop.getProperty("browserName");
		System.out.println(browserName);
		if(browserName.equalsIgnoreCase("chrome"))
	{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
	}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else
		{
	     System.out.println("No browserName matched");
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String url = prop.getProperty("url");
		driver.get(url);
		}
	
}
