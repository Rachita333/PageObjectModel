package com.app.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.app.commonControls.CommonControls;
import com.app.pages.ContactPage;
import com.app.pages.RegisterPage;
import com.app.pages.WelcomePage;



public class RegisterTest extends BaseTest{
	
	
	
	//RegisterPage rPage = new RegisterPage(driver);
	WelcomePage wPage;
	RegisterPage rPage;
	ContactPage cPage;
	//CommonControls cControls;
	
	@BeforeMethod
	public void setup()
	{
		BaseTest.initialization();
		wPage = new WelcomePage(driver);
		wPage.enterUserName(readConfig.getUsername());
		wPage.enterpassowrd(readConfig.getPassword());
		wPage.clickSubmit();
		wPage.verifyWelcomeMessage("Welcome back to Mercury Tours!");
	}
	
	
	
	@Test
	public void verifyRegistrationTest() throws IOException
	{
		//cControls = new CommonControls();
		rPage = new RegisterPage(driver);
		rPage.click_registerLink();
		rPage.enterFirstName("Test");
		rPage.enterLastName("Test1");
		rPage.enterPhone("111222333");
		rPage.enterEmail("a@b.c");
		rPage.enterAddress("1 Thane");
		rPage.enterCity("Mumbai");
		rPage.enterState("MP");
		rPage.enterPostalCode("111111");
		rPage.selectCountry("TURKEY");
		rPage.enterUserName("Jonny");
		rPage.enterPassword("123");
		rPage.enterConfirmPAssword("123");
		rPage.clickBtnSubmit();
		rPage.verifyRegisteredUSer("Test");
		//cControls.switchToFrame(driver, "");
		//cControls.switchToDefaultContent(driver);
		
	}
	
	@Test(priority = 1)
	public void verifyContactLinkTest() throws IOException
	{
		cPage = new ContactPage(driver);
		cPage.clickContactLink();
		cPage.verifyUserONContactPage();
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
