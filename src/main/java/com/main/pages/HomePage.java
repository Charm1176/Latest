package com.main.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
	
	
	
	
	 @FindBy(xpath="//span[@class='caret']")
	private WebElement dropDownSectiion;
	
	 @FindBy(xpath="//a[text()='Login']")
	private WebElement loginDropdownButton;
    
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	
	public void clickOnDropdownSection() {
		dropDownSectiion.click();
	}
	  public void clickOnLogin() {
		  dropDownSectiion.click();
		  loginDropdownButton.click();
		  
	  }
	  
	   public LoginPage navigateToLoginPage() {
		   clickOnLogin();
		   return new LoginPage(driver);
	   }
	  
	  public boolean isVisibleDropdown() {
		  return dropDownSectiion.isDisplayed();
	  }
	  
	  public boolean isLoginVisible() {
		  clickOnDropdownSection();
		  wait.until(ExpectedConditions.visibilityOf(dropDownSectiion));
		  return dropDownSectiion.isDisplayed();
		  
	  }
	  
	 
	  
}
