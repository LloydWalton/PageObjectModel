package com.qa.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.crm.testbase.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name = "title")
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement fName;
	
	@FindBy(name = "surname")
	WebElement lNmae;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@value='Load From Company']/following-sibling::input[1]")
	WebElement save;
	

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean contactsLabelTest()

	{
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name)

	{
		driver.findElement(By.xpath("//a[@_name='" + name + "']/ancestor::tr/td/input[@type='checkbox']")).click();
	}

	public void createNewContact(String nameTitle,String ftName,String ltName,String companyName) {
		Select select=new Select(title);
		select.selectByVisibleText(nameTitle);
		
		fName.sendKeys(ftName);
		lNmae.sendKeys(ltName);
		company.sendKeys(companyName);
		save.click();
		
		

	}

}
