package com.app.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.app.tests.BaseTest;



public class RegisterPage extends BaseTest{

	public WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "REGISTER")
	public static WebElement link_register;

	// Contact Information
	@FindBy(name = "firstName")
	public static WebElement txtBox_FristName;

	@FindBy(name = "lastName")
	public static WebElement txtBox_LastName;

	@FindBy(name = "phone")
	public static WebElement txtBox_Phone;

	@FindBy(name = "userName")
	public static WebElement txtBox_Email;

	// Mailing Information
	@FindBy(name = "address1")
	public static WebElement txtBox_Address;

	@FindBy(name = "city")
	public static WebElement txtBox_City;

	@FindBy(name = "state")
	public static WebElement txtBox_State;

	@FindBy(name = "postalCode")
	public static WebElement txtBox_PostCode;

	@FindBy(name = "country")
	public static WebElement dropDown_Country;

	// User Information
	@FindBy(id = "email")
	public static WebElement txtBox_UserName;

	@FindBy(name = "password")
	public static WebElement txtBox_Password;

	@FindBy(name = "confirmPassword")
	public static WebElement txtBox_ConfirmPassword;

	@FindBy(name = "submit")
	public static WebElement btn_Submit;
	
	public void click_registerLink()
	{
		link_register.click();
	}
	
	public void enterFirstName(String firstName)
	{
		txtBox_FristName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName)
	{
		txtBox_LastName.sendKeys(lastName);
	}
	
	public void enterPhone(String phone)
	{
		txtBox_Phone.sendKeys(phone);
	}
	
	public void enterEmail(String email)
	{
		txtBox_Email.sendKeys(email);
	}

	public void enterAddress(String address)
	{
		txtBox_Address.sendKeys(address);
	}
	
	public void enterCity(String city)
	{
		txtBox_City.sendKeys(city);
	}
	
	
	public void enterState(String state)
	{
		txtBox_State.sendKeys(state);
	}
	
	public void enterPostalCode(String postalCode)
	{
		txtBox_PostCode.sendKeys(postalCode);
	}
	
	public void selectCountry(String country){
	Select selCountry = new Select(dropDown_Country);
	selCountry.selectByVisibleText(country);
	}
	
	public void enterUserName(String username)
	{
		txtBox_UserName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtBox_Password.sendKeys(password);
	}
	
	public void enterConfirmPAssword(String confirmPassword)
	{
		txtBox_ConfirmPassword.sendKeys(confirmPassword);
	}
	
	public void clickBtnSubmit()
	{
		btn_Submit.click();
	}
	
	public void verifyRegisteredUSer(String userCreated) throws IOException
	{
		if(driver.getPageSource().contains(userCreated))
		{
			Assert.assertTrue(true);
		}
		
		else {
			captureScreen(driver, "verifyRegistrationTest");
			Assert.fail();
	}
}
}
