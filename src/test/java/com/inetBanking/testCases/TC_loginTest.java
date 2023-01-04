package com.inetBanking.testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_loginTest extends BaseClass { // baseClass is extended(inheritance) here which means current class can use the base class methods
	
	@Test
	public void loginTest() {
		
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.setUserName(username);
		logger.info("username entered");
		loginPage.setPassword(password);
		logger.info("password entered");
		loginPage.clickSubmit();
		logger.info("login button clicked");
		
		assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage"); 
	}

}
