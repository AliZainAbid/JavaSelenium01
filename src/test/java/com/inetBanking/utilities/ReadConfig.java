package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig() {
		
		File src = new File("./Configuration/config.properties");
		
		try {
			
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("Exception is: "+ e.getMessage());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getApplicationURL() {
		
		String url = properties.getProperty("baseURL");
		return url;
		
	}
	public String getUserName() {
			
			String username = properties.getProperty("username");
			return username;
			
		}
	public String getPassword() {
		
		String password = properties.getProperty("password");
		return password;
		
	}

}
