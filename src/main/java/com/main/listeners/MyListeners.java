package com.main.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.main.utilities.ExtentReporter;
import com.main.utilities.UtilityMethods;

 
public class MyListeners  implements ITestListener  {
	ExtentReports extentReport;
	ExtentTest extentTest;
	private static final Logger logger=LogManager.getLogger(MyListeners.class);
	
	

	@Override
	public void onTestStart(ITestResult result) {
		
		
		logger.info("Test started ",result.getName());
		extentTest=extentReport.createTest(result.getName());
		extentTest.log(Status.INFO, result.getName()+"startedExecuting");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test passed ",result.getName());
		extentTest.log(Status.PASS,result.getName()+"got successfully executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test failed ",result.getName());
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch(Throwable  e) {
			e.printStackTrace();
		}
		String destinationScreenshotPath=UtilityMethods.captureScreenshot(driver,result.getName());
		extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, result.getName()+"got failed");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test case skipped",result.getName());
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+"Got skipped");
	}

	@Override
	public void onStart(ITestContext context) {
	
		extentReport=ExtentReporter.generateExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
		String pathOfExtentReport=System.getProperty("user.dir")+ "\\src\\main\\java\\Reports\\extentReport.html";
			
				File extentReport=new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	
	

}
