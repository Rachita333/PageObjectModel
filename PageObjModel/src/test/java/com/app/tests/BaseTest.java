package com.app.tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

import com.app.util.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	// public static Properties prop;

	static ReadConfig readConfig = new ReadConfig();
	public static String browserName;
	public static String baseURL = readConfig.getApplicationURL();
	

	public static void initialization() {
		browserName = readConfig.getBrowser();
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-features=VizDisplayCompositor");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("ie")) {
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability("nativeEvents", false);
			ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
			ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
			ieCapabilities.setCapability("disable-popup-blocking", true);
			ieCapabilities.setCapability("enablePersistentHover", true);
			WebDriverManager.iedriver().arch32().setup();
			driver = new InternetExplorerDriver(ieCapabilities);
		}
		else {
			System.out.println("Enter proper browser in config file");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
		
	}
	
	
	// call when want to take screenshot
		public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(source, target);
			
		}

	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

	

}
