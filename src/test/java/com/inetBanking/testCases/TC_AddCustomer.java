package com.inetBanking.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomer extends BaseClass
{

	@Test
	public void addCustomerTest() throws InterruptedException, IOException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName(username);
		loginPage.setPassword(password);
		loginPage.clickSubmit();
		Thread.sleep(2000);
		
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		
		addCustomerPage.clickAddNewCustomer();
		Thread.sleep(2000);
		
		addCustomerPage.custName("new name");
		addCustomerPage.custgender("male");
		addCustomerPage.custdob("11", "07", "1985");
		Thread.sleep(2000);
		addCustomerPage.custaddress("new address");
		addCustomerPage.custcity("Lhr");
		addCustomerPage.custstate("Punjab");
		addCustomerPage.custpinno("1122");
		addCustomerPage.custtelephoneno("090078601");
		
		String randomEmail = randomString() + randomInt() + "@test.com"; 
		
		addCustomerPage.custemailid(randomEmail);
		addCustomerPage.custpassword("password");
		addCustomerPage.custsubmit();
		
		
		boolean resp= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(resp == true)
		{
			assertTrue(true); 
		}
		
		else {
			captureScreen(driver, "addCustomerTest");
			assertTrue(false);
		}
		
		
	}
	
}
