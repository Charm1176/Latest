package com.main.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		String name=UtilityMethods.getTime();
		ExtentReports extentReport=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\Reports\\"+"AutomationTestReport"+name+".html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Automation Test Report");
		sparkReporter.config().setDocumentTitle("Automation Report Doc");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		extentReport.attachReporter(sparkReporter);
		Properties configProp=new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\com\\config\\config.properties");
		try {
			FileInputStream fip=new FileInputStream(configPropFile);
			configProp.load(fip);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReport.setSystemInfo("valid Email",configProp.getProperty("validEmail"));
		extentReport.setSystemInfo("valid Password",configProp.getProperty("validPassword"));
		extentReport.setSystemInfo("Operating System","Windows");
		extentReport.setSystemInfo("Designation", "Senior Quality Analyst");
		extentReport.setSystemInfo("java version","java 17");
		
		return extentReport;
		
	}

}
