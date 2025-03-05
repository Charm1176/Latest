package com.main.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.main.pages.HomePage;
import com.main.pages.LoginPage;
import com.main.qa.BaseTest;

public class LoginPageTest  extends BaseTest {
	LoginPage loginPage;
	
	public WebDriver driver;
   
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		 
		 driver=intializeBrowser(prop.getProperty("browserName"));
		 logger=Logger.getLogger("Main");	
		 PropertyConfigurator.configure("C:\\Joker\\Main\\Configuration\\log4j.properties");
		 HomePage homePage=new HomePage(driver);
		 loginPage=homePage.navigateToLoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		logger.info("browser closed");
	}
	
	@Test(priority=1)
	public void checkingEmailTextBox() {
		Assert.assertEquals(loginPage.emailTextBoxIsDisplayed(), true);
		logger.info("verify LoginPage  emailTextBox displayed");
	}
	
	@Test(priority=2)
	public void checkingPasswordTextBox() {
		Assert.assertEquals(loginPage.passwordTextBoxIsDisplayed(),true);
		logger.info("verify LoginPage passwordText Displayed");
	}
	
	@Test(priority=3)
	public void checkingMainLoginButton() {
		Assert.assertEquals(loginPage.mainloginButtonIsDisplayed(), true);
		logger.info("Verify LoginPage LoginButton Displayed");
	}
	
	

}
