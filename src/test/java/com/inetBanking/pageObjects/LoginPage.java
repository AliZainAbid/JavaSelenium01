package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver localDriver; //initialise the webDriver
	
	public LoginPage(WebDriver remoteDriver) { //implement the constructor method
		
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this); //initialise the page factory
		
	}
	
	// identify the locators with FindBy
	
	@FindBy(name="uid")
	WebElement txtUserName;

	@FindBy(name="password")
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	WebElement btnLogin;

	@FindBy(css = "[href='Logout.php']")
	WebElement btnLogout;
	
	// methods to interact with the elements
	
	public void setUserName(String userName) {
		txtUserName.sendKeys(userName);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickSubmit() {
		btnLogin.click();
	}

	public void clickLogout() {
		btnLogout.click();
	}
	
	
}
