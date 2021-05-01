// Added Comment
package com.qa.crm.testcases;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.crm.pages.HomePage;
import com.qa.crm.pages.LoginPage;
import com.qa.crm.testbase.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	
	HomePage homepage; // Page linking purpose
	
	
	
	
	public  LoginPageTest() {
		super();  // to initialize prop file
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		 loginpage=new LoginPage(); // to call login page methods
	}
	
	@Test(priority = 1)
	public void titleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
		
	}
	
	@Test(priority = 2)
	public void crmLogoTest()
	{
		boolean flag=loginpage.validateCrmImage();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
