package com.main.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.pages.AccountPage;
import com.main.pages.HomePage;
import com.main.pages.LoginPage;
import com.main.qa.BaseTest;

public class AccountPageTest extends BaseTest{
	AccountPage accountPage;
	
	public WebDriver driver;
	
	public AccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		driver=intializeBrowser(prop.getProperty("browserName"));
        logger=Logger.getLogger("Main");
		PropertyConfigurator.configure("C:\\Joker\\Main\\Configuration\\log4j.properties");
		HomePage homePage=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver);
	    loginPage=homePage.navigateToLoginPage();
	    accountPage=new AccountPage(driver);
	    accountPage=loginPage.clickOnLogin(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
	   
	}
	
	@AfterMethod
	public void tearDown() {
		logger.info("closing browser");
		driver.close();
	}
	
	@Test(priority=3)
	public void verifyUrl() {
		logger.info("Verify URl");
		Assert.assertEquals(accountPage.getUrl(),prop.getProperty("accountPageUrl"));
	
	}
	@Test(priority=1)
	public void checkingAccountpageElement() {
		
		Assert.assertEquals(accountPage.isAccountPageTextElementVisible(),true);
		logger.info("Verified accountPage");
	}
	
	@Test(priority=2)
	public void checkingDesktopElement() {
		Assert.assertEquals(accountPage.isDeskTopSectionVisible(),true);
		logger.info("Verified CheckingDesktopElement");
	}
	
	
	@Test(priority=4)
	public void verifyTitle() {
		String title=driver.getTitle();
		Assert.assertEquals(title, prop.getProperty("accountTitle"));
		logger.info("AccountPage title Verified");
		System.out.println("---------------");
	}
	
	@Test(priority=5)
	public void checkingJust() {
		Assert.assertTrue(true);
	}


}
