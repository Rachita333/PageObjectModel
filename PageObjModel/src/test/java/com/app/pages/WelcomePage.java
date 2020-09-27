package com.app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class WelcomePage {

	public WebDriver driver;

	public WelcomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userName")
	public static WebElement txtBox_userName;

	@FindBy(name = "password")
	public static WebElement txtBox_password;

	@FindBy(name = "submit")
	public static WebElement btn_login;

	@FindBy(xpath = "//b")
	public static WebElement txt_welcomeMsg;

	public void enterUserName(String username) {
		txtBox_userName.sendKeys(username);
	}

	public void enterpassowrd(String Password) {
		txtBox_password.sendKeys(Password);
	}

	public void clickSubmit() {
		btn_login.click();
	}

	public void verifyWelcomeMessage(String message) {
		if (txt_welcomeMsg.getText().contains(message)) {
			Assert.assertTrue(true);
		}

	}

}
