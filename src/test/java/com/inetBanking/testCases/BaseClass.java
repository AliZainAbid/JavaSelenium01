package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import freemarker.log.Logger;

public class BaseClass { // base class is created for all the common methods, // all other classes will inherit the baseClass
	
	ReadConfig readConfig = new ReadConfig();
	
	
	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUserName();
	public String password = readConfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	// basic setup to initialise the browser
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		
		
		// configure the log4j for logging
		// Log4j.properties is imported for logger configuration
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");
		BasicConfigurator.configure();
		
		System.setProperty("org.freemarker.loggerLibrary", "none");
		
		if(browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
			}
		// add implicit wait for all test cases
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get(baseURL);
		logger.info("url is opened");
	}
	
	
	// after the test case, browser should be closed
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshot/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomString() {
		
		String randomString =  RandomStringUtils.randomAlphabetic(6);
		return randomString;
		
	}
	

	public String randomInt() {
		
		String randomString =  RandomStringUtils.randomNumeric(5);
		return randomString;
		
	}
	
}
