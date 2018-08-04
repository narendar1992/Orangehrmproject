package com.hrm.qa.pages;

import static org.testng.Assert.assertEquals;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.testutil.Synchronization;

public class Loginpage extends TestBase {

	//Defining Object Repository
	
	@FindBy(name="txtUsername")
	WebElement username;
	
	@FindBy(name="txtPassword")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement loginbtn;
	 
	
	@FindBy(xpath="//div[@id='divLogo']/img")
	WebElement hrmlogo;
	
	// initilizing the pagefactory
	
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	
		}
	
	public String validateTitle()
	{
		return driver.getTitle();
		}
	public boolean checkhrmlogo()
	{
		return hrmlogo.isDisplayed();
		
	}
	
	public Homepage Login(String un, String pwd)
	{
	username.sendKeys(prop.getProperty(un));	
	password.sendKeys(prop.getProperty(pwd));
	loginbtn.click();
	return new Homepage();

	}
	
	}
