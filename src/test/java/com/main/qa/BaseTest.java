package com.main.qa;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


public class BaseTest {
	WebDriver driver;
	public Properties prop;
	public static Logger logger;
	
	//PropertyConfigurator.configure("C:\\Joker\\Main\\Configuration\\log4j.properties");
	
	
	
	
	public BaseTest() {
		
		
		//PropertyConfigurator.configure("C:\\Joker\\Main\\Configuration\\log4j.properties");
		prop =new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\com\\config\\config.properties");
		try {
			FileInputStream fis=new FileInputStream(propFile);
			prop.load(fis);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver intializeBrowser(String browserName) {

		
		
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
	
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        logger=Logger.getLogger("Main");
		
		PropertyConfigurator.configure("C:\\Joker\\Main\\Configuration\\log4j.properties");
		logger.info("Browser invoiked  "+browserName);		
		return driver;
	}

}
