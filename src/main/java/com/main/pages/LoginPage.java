package com.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	 @FindBy(xpath="//input[@id='input-email']")
	 private WebElement emailTextBox;
	
	
	 @FindBy(xpath="//input[@id='input-password']")
	private WebElement passwordTextBox;
	
	
    @FindBy(xpath="//input[@type='submit']")
	private WebElement mainLogin;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}
	
	
	public void  enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public boolean mainloginButtonIsDisplayed() {
		return mainLogin.isDisplayed();
	}
	
	public boolean emailTextBoxIsDisplayed() {
		return emailTextBox.isDisplayed();
	}
	
	public boolean passwordTextBoxIsDisplayed() {
		return passwordTextBox.isDisplayed();
	}
	
	public AccountPage clickOnLogin(String email,String password) {
		enterEmail(email);
		enterPassword(password);
		mainLogin.click();
		return new AccountPage(driver);
	}
	
	
     
	
	
	
}
