package com.main.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.pages.HomePage;
import com.main.qa.BaseTest;

public class HomepageTest extends BaseTest {
	public WebDriver driver;
	HomePage homePage;
	public static Logger logger;
	
	public HomepageTest() {
	    super();
	}
	
	@BeforeMethod
	public void setup() {
	
		driver=intializeBrowser(prop.getProperty("browserName"));
		homePage=new HomePage(driver);
logger=Logger.getLogger("Main");
		
		PropertyConfigurator.configure("C:\\Joker\\Main\\Configuration\\log4j.properties");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void verifyDropdownSection() {
		Assert.assertEquals(homePage.isVisibleDropdown(), true);
		logger.info("Verify HomePage DropdownSection");
	}
	
	@Test(priority=2)
	public void verifyLoginDropdown() {
		Assert.assertEquals(homePage.isLoginVisible(), true);
		logger.info("Verify HomePage loginDropDown");
	}
}
