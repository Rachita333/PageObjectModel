package com.app.commonControls;

import org.openqa.selenium.WebDriver;

public class CommonControls {
	
	
	public void switchToFrame(WebDriver driver, String frameId)
	{
		driver.switchTo().frame(frameId);
		
	}
	
	
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();
		
	}

}
