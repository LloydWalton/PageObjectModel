package com.qa.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.testbase.TestBase;
import com.qa.crm.util.Util;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	Util util;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void login() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		util = new Util();
		contactsPage= new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // Login is returning to
																								// homepage

	}

	// Make sure test cases are independent

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homepageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO", "HomePage title is mismatched");
	}

	@Test(priority = 2)
	public void verifyHomePageUserNameTest() {
		util.switchFrame("mainpanel"); // Switching control inside frame (Generic so moved to util class)
		Assert.assertTrue(homePage.verifyHomePageUsernameText());
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		util.switchFrame("mainpanel");
		contactsPage=homePage.clickOnContactsLink();
	}
	
	
	
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
