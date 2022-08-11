package com.ohrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends TestBase{
	
public static  long  PAGE_LOAD_TIMEOUT=20;
public static long IMPLICIT_WAIT=10;
public void sleep()
{
try {
	Thread.sleep(IMPLICIT_WAIT);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public static void captureScreenShot() throws IOException
{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		try {
			FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" 
		+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}

}