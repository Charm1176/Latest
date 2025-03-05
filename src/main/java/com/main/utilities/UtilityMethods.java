package com.main.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityMethods {
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationPath=System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		
		try {
			FileHandler.copy(srcScreenshot, new File(destinationPath));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return destinationPath;
	}
   public static String getTime() {
	   DateTimeFormatter df=DateTimeFormatter.ofPattern("dd MM yy HH mm");
	   LocalDateTime now=LocalDateTime.now();
	   String timeValue=df.format(now);
	   String value=timeValue.replace(" ", "");
	    return value;
   }
}
