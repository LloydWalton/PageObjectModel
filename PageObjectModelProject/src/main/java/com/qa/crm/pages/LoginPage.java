package com.qa.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qa.crmtest.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory
	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//button[contains(text(),'Sign Up']")
	WebElement signUpBtn;

	@FindBy(xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmLogo;

	public LoginPage() {
		PageFactory.initElements(driver, this); // to initialize page factory web elements
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCrmImage() {
		return crmLogo.isDisplayed();
	}

	public HomePage login(String un, String pwd) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		loginBtn.click();
		return new HomePage(); // Returning to homepage (Page Linking)

	}

}
