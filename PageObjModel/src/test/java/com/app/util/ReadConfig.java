package com.app.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadConfig {

	public WebDriver driver;
	Properties pro;

	public  String configFile = System.getProperty("user.dir") + "\\config.properties";
	public ReadConfig() {
		
		File src = new File(configFile);

		try {
			FileInputStream fis = new FileInputStream(src);
			 pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}

	public String getUsername() {
		String username = pro.getProperty("userName");
		return username;
	}

	public String getPassword() {
		String password = pro.getProperty("password");
		return password;
	}

	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}

	
	
}
