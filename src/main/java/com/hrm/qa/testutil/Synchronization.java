package com.hrm.qa.testutil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {
	
//using Explicit wait sendkeys method
	
	public static void senkeys(WebDriver driver ,WebElement element, int Timeout , String value)
	{
	new WebDriverWait(driver, Timeout).until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);
			}
	
////using Explicit wait clickon method
	public static void clickon(WebDriver driver , WebElement element , int timeout)
	{
	
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}

}
