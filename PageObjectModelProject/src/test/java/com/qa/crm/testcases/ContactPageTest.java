package com.qa.crm.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.crm.pages.ContactsPage;
import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.util.Util;

import com.qa.crmtest.base.TestBase;

public class ContactPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	Util util;

	public ContactPageTest() {
		super();

	}

	@BeforeMethod
	public void login() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		util = new Util();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // Login is returning to
		util.switchFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink(); // homepage
	}

	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactsPage.contactsLabelTest());
	}

	@Test(priority = 2)
	public void clickOnSingleContactsTest() {
		contactsPage.selectContactsByName("bhushan ");

	}

	@Test(priority = 3)
	public void clickOnMultipleContactsTest() {
		contactsPage.selectContactsByName("bb jjj");
		contactsPage.selectContactsByName("bhushan ");

	}

	@DataProvider
	public Object[][] getTestData() throws InvalidFormatException {
		Object data[][] = Util.getTestData("Contacts");
		return data;

	}

	@Test(priority = 4, dataProvider = "getTestData") // Data driven approach
	public void validateCreateNewContact(String title, String fName, String lName, String company)
			throws InterruptedException {
		homePage.clickOnNewContactsLink();
		contactsPage.createNewContact(title, fName, lName, company);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
