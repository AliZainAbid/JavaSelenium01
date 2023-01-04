package com.inetBanking.testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT extends BaseClass
{

	@Test(dataProvider = "getData")
	public void loginDDT(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("username added");
		loginPage.setPassword(password);
		logger.info("password added");
		loginPage.clickSubmit();
		logger.info("login button clicked");
		
		if(isAlertPresent()) {
			
			driver.switchTo().alert().accept(); // accept the alert
			logger.info("alert handled");
			driver.switchTo().defaultContent();
			assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			assertTrue(true);
			loginPage.clickLogout();
			logger.info("login passed");
			driver.switchTo().alert().accept(); //close the logout alert
			logger.info("alert handled");
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
			
		} catch (NoAlertPresentException e) {
			// TODO: handle exception
			return false;
		}
		
		
	}
	
	
	
	@DataProvider(name="getData")
	String[][] loginData() throws IOException {
		
		String path = System.getProperty("user.dir") + "//src//test//java//com//inetBanking//testData//LoginData.xlsx";
		
		int rowCount = XLUtils.getRowCount(path, "Sheet1");
		int colCount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][] = new String[rowCount][colCount];
		
		for(int i =1; i<=rowCount; i++) {
			for(int j =0; j<colCount;j++) {
				loginData[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
}
