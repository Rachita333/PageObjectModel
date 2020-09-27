package com.app.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.app.tests.BaseTest;





public class ContactPage extends BaseTest{
	public WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "CONTACT")
	public static WebElement link_contact;

	public void clickContactLink() {
		link_contact.click();
	}
	
	public void verifyUserONContactPage() throws IOException
	{
		if(driver.getPageSource().contains("BACK TO HOME"))
		{
			Assert.assertTrue(true);
		}
		else {
			captureScreen(driver, "verifyContactLinkTest");
			Assert.fail();
	}

}
}
