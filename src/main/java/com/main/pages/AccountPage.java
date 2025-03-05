package com.main.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	WebDriver driver;
	

	@FindBy(xpath="//h2[text()='My Account']")
	private WebElement accountPageTextElement;
	
	@FindBy(xpath="//li//a[text()='Desktops']")
	private WebElement desktopSection;
	
	@FindBy(xpath="//aside//a[text()='Logout']")
	private WebElement logutLink;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	public String  getUrl() {
		return driver.getCurrentUrl();
	}
	
	
	 public boolean isAccountPageTextElementVisible() {
			return  accountPageTextElement.isDisplayed();
			
		}
		public boolean isDeskTopSectionVisible() {
			return  desktopSection.isDisplayed();
		}
	  
	

}

	
	


